package com.speedware.gestaovendas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.speedware.gestaovendas.dto.venda.ClienteVendaResponseDTO;

import com.speedware.gestaovendas.dto.venda.VendaRequestDTO;
import com.speedware.gestaovendas.dto.venda.VendaResponseDTO;
import com.speedware.gestaovendas.dto.venda.itemVendaRequestDTO;
import com.speedware.gestaovendas.entities.Cliente;
import com.speedware.gestaovendas.entities.ItemVenda;
import com.speedware.gestaovendas.entities.Produto;
import com.speedware.gestaovendas.entities.Venda;
import com.speedware.gestaovendas.exceptions.RegraNegocioExeption;
import com.speedware.gestaovendas.repositorys.ItemVendaRepository;
import com.speedware.gestaovendas.repositorys.VendaRepository;

@Service
public class VendaService extends AbstractVendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ItemVendaRepository itemVendaRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	public ClienteVendaResponseDTO listarVendaPorCliente(Long codigoCliente) {

		Cliente cliente = validarClienteVendaExiste(codigoCliente);
		List<VendaResponseDTO> vendaResponseDtoList = vendaRepository.findByCliente(codigoCliente).stream().map(
				venda -> criandoVendaResponseDTO(venda, itemVendaRepository.findByVendaPorCodigo(venda.getCodigo())))
				.collect(Collectors.toList());
		return new ClienteVendaResponseDTO(cliente.getNome(), vendaResponseDtoList);
	}

	public ClienteVendaResponseDTO listarVendaPorCodigo(Long codigoVenda) {

		Venda venda = validarVendaExiste(codigoVenda);
		List<ItemVenda> itensVendaList = itemVendaRepository.findByVendaPorCodigo(venda.getCodigo());
		return retornandoClienteVendaResponseDTO(venda, itensVendaList);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public ClienteVendaResponseDTO salvar(Long codigoCliente, VendaRequestDTO vendaDto) {

		Cliente cliente = validarClienteVendaExiste(codigoCliente);
		validarProdutoExisteEAtualizarQuantidade(vendaDto.getItensVendaDto());
		Venda vendaSalva = salvarVenda(cliente, vendaDto);
		return retornandoClienteVendaResponseDTO(vendaSalva,
				itemVendaRepository.findByVendaPorCodigo(vendaSalva.getCodigo()));

	}

	public ClienteVendaResponseDTO atualizar(Long codigoVenda, Long codigoCliente, VendaRequestDTO vendaDto) {

		validarVendaExiste(codigoVenda);
		Cliente cliente = validarClienteVendaExiste(codigoCliente);
		List<ItemVenda> itensVendaList = itemVendaRepository.findByVendaPorCodigo(codigoVenda);
		validarProdutoExisteEDevolverEstoque(itensVendaList);
		validarProdutoExisteEAtualizarQuantidade(vendaDto.getItensVendaDto());
		itemVendaRepository.deleteAll(itensVendaList);
		Venda vendaAtualizada = atualizarVenda(codigoVenda, cliente, vendaDto);
		return retornandoClienteVendaResponseDTO(vendaAtualizada,
				itemVendaRepository.findByVendaPorCodigo(vendaAtualizada.getCodigo()));
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void deletar(Long codigoVenda) {

		validarVendaExiste(codigoVenda);
		List<ItemVenda> itensVenda = itemVendaRepository.findByVendaPorCodigo(codigoVenda);
		validarProdutoExisteEDevolverEstoque(itensVenda);
		itemVendaRepository.deleteAll(itensVenda);
		vendaRepository.deleteById(codigoVenda);
	}

	private void validarProdutoExisteEDevolverEstoque(List<ItemVenda> itensVenda) {

		itensVenda.forEach(item -> {

			Produto produto = produtoService.validarProdutoExiste(item.getProduto().getCodigo());
			produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
			produtoService.atualizarQuantidadeEmEstoque(produto);
		});

	}

	private Venda salvarVenda(Cliente cliente, VendaRequestDTO vendaDto) {

		Venda vendaSalva = vendaRepository.save(new Venda(vendaDto.getData(), cliente));
		vendaDto.getItensVendaDto().stream().map(itemVendaDto -> criandoItemVenda(itemVendaDto, vendaSalva))
				.forEach(itemVendaRepository::save);
		return vendaSalva;
	}

	private Venda atualizarVenda(Long codigoVenda, Cliente cliente, VendaRequestDTO vendaDto) {

		Venda vendaSalva = vendaRepository.save(new Venda(codigoVenda, vendaDto.getData(), cliente));
		vendaDto.getItensVendaDto().stream().map(itemVendaDto -> criandoItemVenda(itemVendaDto, vendaSalva))
				.forEach(itemVendaRepository::save);
		return vendaSalva;
	}

	private void validarProdutoExisteEAtualizarQuantidade(List<itemVendaRequestDTO> itensVendaDto) {

		itensVendaDto.forEach(item -> {
			Produto produto = produtoService.validarProdutoExiste(item.getCodigoProduto());
			validarQuantidadeProdutoExiste(produto, item.getQuantidade());
			produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
			produtoService.atualizarQuantidadeEmEstoque(produto);
		});

	}

	private void validarQuantidadeProdutoExiste(Produto produto, Integer qtdeVendaDto) {

		if (!(produto.getQuantidade() >= qtdeVendaDto)) {

			throw new RegraNegocioExeption(
					String.format("A quantidade %s informada para o produto não está disponivel em estoque",
							qtdeVendaDto, produto.getDescricao()));

		}

	}

	private Venda validarVendaExiste(Long codigoVenda) {

		Optional<Venda> venda = vendaRepository.findById(codigoVenda);
		if (venda.isEmpty()) {

			throw new RegraNegocioExeption(String.format("Venda de codigo %s não encontrada", codigoVenda));

		}
		return venda.get();

	}

	private Cliente validarClienteVendaExiste(Long codigoCliente) {

		Optional<Cliente> cliente = clienteService.buscarPorCodigo(codigoCliente);

		if (cliente.isEmpty()) {

			throw new RegraNegocioExeption(
					String.format("O cliente de código informado não existe no cadastro", codigoCliente));

		}
		return cliente.get();

	}

}
