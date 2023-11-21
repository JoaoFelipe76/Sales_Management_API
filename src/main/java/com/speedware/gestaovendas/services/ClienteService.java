package com.speedware.gestaovendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.speedware.gestaovendas.entities.Cliente;
import com.speedware.gestaovendas.exceptions.RegraNegocioExeption;
import com.speedware.gestaovendas.repositorys.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listarTodos() {

		return clienteRepository.findAll();

	}

	public Optional<Cliente> buscarPorCodigo(Long codigo) {

		return clienteRepository.findById(codigo);

	}

	public Cliente salvarCliente(Cliente cliente) {

		validarClienteDuplicado(cliente);
		return clienteRepository.save(cliente);

	}

	public Cliente atualizarCliente(Long codigo, Cliente cliente) {

		Cliente clienteAtualizar = validarClienteExiste(codigo);
		validarClienteDuplicado(cliente);
		BeanUtils.copyProperties(cliente, clienteAtualizar);
		return clienteRepository.save(clienteAtualizar);

	}

	public void deletarCliente(Long codigo) {

		clienteRepository.deleteById(codigo);

	}

	private Cliente validarClienteExiste(Long codigo) {

		Optional<Cliente> cliente = buscarPorCodigo(codigo);
		if (cliente.isEmpty()) {

			throw new EmptyResultDataAccessException(1);

		}
		return cliente.get();

	}

	private void validarClienteDuplicado(Cliente cliente) {

		Cliente clientePorNome = clienteRepository.findByNome(cliente.getNome());
		if (clientePorNome != null && clientePorNome.getCodigo() != cliente.getCodigo()) {
			throw new RegraNegocioExeption(
					String.format("O cliente %s já está cadastrado", cliente.getNome().toUpperCase()));
		}
	}

}
