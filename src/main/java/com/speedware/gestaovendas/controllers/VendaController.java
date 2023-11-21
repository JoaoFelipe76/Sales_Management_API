package com.speedware.gestaovendas.controllers;

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

import com.speedware.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.speedware.gestaovendas.dto.venda.VendaRequestDTO;
import com.speedware.gestaovendas.services.VendaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Venda")
@RestController
@RequestMapping("/venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@Operation(summary = "Listar vendas por cliente")
	@GetMapping("/cliente/codigoCliente")
	public ResponseEntity<ClienteVendaResponseDTO> listarVendaPorCliente(@PathVariable Long codigoCliente) {

		return ResponseEntity.ok(vendaService.listarVendaPorCliente(codigoCliente));

	}

	@Operation(summary = "Listar vendas por código")
	@GetMapping("/{codigoVenda}")
	public ResponseEntity<ClienteVendaResponseDTO> listarVendaPorCodigo(@PathVariable Long codigoVenda) {

		return ResponseEntity.ok(vendaService.listarVendaPorCodigo(codigoVenda));

	}

	@Operation(summary = "Registrar venda")
	@PostMapping("/cliente/codigoCliente")
	public ResponseEntity<ClienteVendaResponseDTO> salvar(@PathVariable Long codigoCliente,
			@RequestBody VendaRequestDTO vendaDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.salvar(codigoCliente, vendaDto));

	}

	@Operation(summary = "Atualizar venda")
	@PutMapping("{codigoVenda}/cliente/codigoCliente")
	public ResponseEntity<ClienteVendaResponseDTO> atualizar(@PathVariable Long codigoVenda,
			@PathVariable Long codigoCliente, @RequestBody VendaRequestDTO vendaDto) {

		return ResponseEntity.ok(vendaService.atualizar(codigoVenda, codigoCliente, vendaDto));

	}

	@Operation(summary = "Deletar venda")
	@DeleteMapping("/{codigoVenda}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigoVenda) {

		vendaService.deletar(codigoVenda);

	}

}
