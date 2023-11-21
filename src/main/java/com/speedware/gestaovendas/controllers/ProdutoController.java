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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.speedware.gestaovendas.dto.produto.ProdutoRequestDTO;
import com.speedware.gestaovendas.dto.produto.ProdutoResponseDTO;
import com.speedware.gestaovendas.entities.Produto;
import com.speedware.gestaovendas.services.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Produto")
@RestController
@RequestMapping("/categoria{codigoCategoria}/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Operation(summary = "Listar Produto")
	@GetMapping
	public List<ProdutoResponseDTO> listarTodas(@PathVariable Long codigoCategoria) {

		return produtoService.listarTodos(codigoCategoria).stream()
				.map(produto -> ProdutoResponseDTO.converterParaProdutoDTO(produto)).collect(Collectors.toList());

	}

	@Operation(summary = "Listar Produto por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long codigoCategoria,
			@PathVariable Long codigo) {

		Optional<Produto> produto = produtoService.buscarPorCodigo(codigo, codigoCategoria);
		return produto.isPresent() ? ResponseEntity.ok(ProdutoResponseDTO.converterParaProdutoDTO(produto.get()))
				: ResponseEntity.notFound().build();

	}

	@Operation(summary = "Inserir Produto")
	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> inserir(@PathVariable Long codigoCategoria, @Valid @RequestBody ProdutoRequestDTO produto) {

		Produto inserir = produtoService.salvarProduto(codigoCategoria, produto.converterParaEntidade(codigoCategoria));
		return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoResponseDTO.converterParaProdutoDTO(inserir));

	}

	@Operation(summary = "Atualizar Produto")
	@PutMapping("/{codigoProduto}")
	public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long codigoCategoria, @PathVariable Long codigoProduto,
			@Valid @RequestBody ProdutoRequestDTO produto) {
		Produto produtoAtualizado = produtoService.atualizarProduto(codigoCategoria, codigoProduto, produto.converterParaEntidade(codigoCategoria, codigoProduto));
		return ResponseEntity.ok(ProdutoResponseDTO.converterParaProdutoDTO(produtoAtualizado));

	}

	@Operation(summary = "Deletar Produto")
	@DeleteMapping("/{codigoProduto}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigoCategoria, @PathVariable Long codigoProduto) {

		produtoService.deletarProduto(codigoCategoria, codigoProduto);

	}

}
