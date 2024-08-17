package com.speedware.gestaovendas.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.speedware.gestaovendas.dto.cliente.ClienteRequestDTO;
import com.speedware.gestaovendas.dto.cliente.ClienteResponseDTO;

import com.speedware.gestaovendas.entities.Cliente;
import com.speedware.gestaovendas.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Operation(summary = "Listar Clientes")
	@GetMapping
	public List<ClienteResponseDTO> listarTodas() {

		return clienteService.listarTodos().stream().map(cliente -> ClienteResponseDTO.converterParaClienteDTO(cliente))
				.collect(Collectors.toList());
	}

	@Operation(summary = "Listar Clientes por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long codigo) {

		Optional<Cliente> cliente = clienteService.buscarPorCodigo(codigo);
		return cliente.isPresent() ? ResponseEntity.ok(ClienteResponseDTO.converterParaClienteDTO(cliente.get()))
				: ResponseEntity.notFound().build();

	}

	@Operation(summary = "Inserir Cliente")
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> inserir(@Valid @RequestBody ClienteRequestDTO clienteDto) {

		Cliente clienteSalvar = clienteService.salvarCliente(clienteDto.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ClienteResponseDTO.converterParaClienteDTO(clienteSalvar));
	}
	
	@Operation(summary = "Atualizar Cliente")
	@PutMapping("/{codigo}")
	public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long codigo,@Valid @RequestBody ClienteRequestDTO clienteDto){
		
		Cliente clienteAtualizado = clienteService.atualizarCliente(codigo, clienteDto.converterParaEntidade(codigo));
	    return ResponseEntity.ok(ClienteResponseDTO.converterParaClienteDTO(clienteAtualizado));
		
	}
	
	@Operation(summary = "Deletar Cliente")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleter(@PathVariable Long codigo ) {
		
		clienteService.deletarCliente(codigo);
		
	}

}
