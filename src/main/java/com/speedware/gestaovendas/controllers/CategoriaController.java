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

import com.speedware.gestaovendas.dto.categoria.CategoriaRequestDTO;
import com.speedware.gestaovendas.dto.categoria.CategoriaResponseDTO;
import com.speedware.gestaovendas.entities.Categoria;
import com.speedware.gestaovendas.services.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Categoria")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	 
	@Autowired
	private CategoriaService categoriaService;

	@Operation(summary = "Listar Categoria")
	@GetMapping
	public List<CategoriaResponseDTO> listarTodas() {

		return categoriaService.listarTodas().stream()
				.map(categoria -> CategoriaResponseDTO.converterParaCategoriaDTO(categoria))
				.collect(Collectors.toList());

	}

	@Operation(summary = "Listar Categoria por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long codigo) {

		Optional<Categoria> categoria = categoriaService.buscarPorCodigo(codigo);
		return categoria.isPresent()
				? ResponseEntity.ok(CategoriaResponseDTO.converterParaCategoriaDTO(categoria.get()))
				: ResponseEntity.notFound().build();

	}

	@Operation(summary = "Inserir Categoria")
	@PostMapping
	public ResponseEntity<CategoriaResponseDTO> inserir(@Valid @RequestBody CategoriaRequestDTO categoriaDto) {

		Categoria inserir = categoriaService.salvarCategoria(categoriaDto.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaResponseDTO.converterParaCategoriaDTO(inserir));

	}

	@Operation(summary = "Atualizar Categoria")
	@PutMapping("/{codigo}")
	public ResponseEntity<CategoriaResponseDTO> atualizar(@Valid @PathVariable Long codigo,
			@RequestBody CategoriaRequestDTO categoriaDto) {
		Categoria categoriaAtualizada = categoriaService.atualizarCategoria(codigo, categoriaDto.converterParaEntidade(codigo));
		return ResponseEntity.ok(CategoriaResponseDTO.converterParaCategoriaDTO(categoriaAtualizada));

	}

	@Operation(summary = "Deletar Categoria")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {

		categoriaService.deletarCategoria(codigo);

	}

}