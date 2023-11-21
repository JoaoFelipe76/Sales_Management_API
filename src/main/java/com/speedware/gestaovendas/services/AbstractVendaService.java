package com.speedware.gestaovendas.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.speedware.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.speedware.gestaovendas.dto.venda.ItemVendaResponseDTO;
import com.speedware.gestaovendas.dto.venda.VendaResponseDTO;
import com.speedware.gestaovendas.dto.venda.itemVendaRequestDTO;
import com.speedware.gestaovendas.entities.ItemVenda;
import com.speedware.gestaovendas.entities.Produto;
import com.speedware.gestaovendas.entities.Venda;

public class AbstractVendaService {

	protected VendaResponseDTO criandoVendaResponseDTO(Venda venda, List<ItemVenda> itensVendaList) {

		List<ItemVendaResponseDTO> itensVendaResponseDto = itensVendaList.stream()
				.map(this::criandoItensVendaResponseDto).collect(Collectors.toList());
		return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itensVendaResponseDto);

	}

	protected ItemVendaResponseDTO criandoItensVendaResponseDto(ItemVenda itemVenda) {

		return new ItemVendaResponseDTO(itemVenda.getCodigo(), itemVenda.getQuantidade(), itemVenda.getPrecoVendido(),
				itemVenda.getProduto().getCodigo(), itemVenda.getProduto().getDescricao());

	}

	protected ClienteVendaResponseDTO retornandoClienteVendaResponseDTO(Venda venda, List<ItemVenda> itensVendaList) {

		return new ClienteVendaResponseDTO(venda.getCliente().getNome(),
				Arrays.asList(criandoVendaResponseDTO(venda, itensVendaList)));

	}
	
	protected ItemVenda criandoItemVenda(itemVendaRequestDTO itemVendaDto, Venda venda) {

		return new ItemVenda(itemVendaDto.getQuantidade(), itemVendaDto.getPrecoVendido(),
				new Produto(itemVendaDto.getCodigoProduto()), venda);

	}

}
