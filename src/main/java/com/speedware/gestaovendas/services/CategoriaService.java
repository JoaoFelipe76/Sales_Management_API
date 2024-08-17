package com.speedware.gestaovendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.speedware.gestaovendas.entities.Categoria;
import com.speedware.gestaovendas.exceptions.RegraNegocioExeption;
import com.speedware.gestaovendas.repositorys.CategoriaRepository;

@Service 
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listarTodas() {

		return categoriaRepository.findAll();

	}

	public Optional<Categoria> buscarPorCodigo(Long codigo) {

		return categoriaRepository.findById(codigo);

	}

	public Categoria salvarCategoria(@RequestBody Categoria categoria) {
        
		validarCategoriaDuplicada(categoria);
		return categoriaRepository.save(categoria);

	}

	public Categoria atualizarCategoria(Long codigo, Categoria categoria) {

		Categoria categoriaSalvar = validarCategoriaExiste(codigo);
		validarCategoriaDuplicada(categoria);
		BeanUtils.copyProperties(categoria, categoriaSalvar, "codigo");
		return categoriaRepository.save(categoriaSalvar);
	}
	
	public void deletarCategoria(Long codigo) {
		
		categoriaRepository.deleteById(codigo);
		
	}

	private Categoria validarCategoriaExiste(Long codigo) {

		Optional<Categoria> categoria = buscarPorCodigo(codigo);
		if (categoria.isEmpty()) {

			throw new EmptyResultDataAccessException(1);

		}
		return categoria.get();
	}
	
        private void validarCategoriaDuplicada(Categoria categoria) {
	    List<Categoria> categoriasEncontradas = categoriaRepository.findByNome(categoria.getNome());

	    
	    if (!categoriasEncontradas.isEmpty()) {
	        
	        for (Categoria categoriaEncontrada : categoriasEncontradas) {
	            if (!categoriaEncontrada.getCodigo().equals(categoria.getCodigo())) {
	                throw new RegraNegocioExeption(
	                        String.format("A categoria %s já está cadastrada", categoria.getNome().toUpperCase()));
	            }
	        }
	    }
	}}

