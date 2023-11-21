package com.speedware.gestaovendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.speedware.gestaovendas.entities.Produto;
import com.speedware.gestaovendas.exceptions.RegraNegocioExeption;
import com.speedware.gestaovendas.repositorys.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaService categoriaService;

	public List<Produto> listarTodos(Long codigoCategoria) {

		return produtoRepository.findByCategoriaCodigo(codigoCategoria);

	}

	public Optional<Produto> buscarPorCodigo(Long codigo, Long codigoCategoria) {

		return produtoRepository.buscarPorCodigo(codigo, codigoCategoria);

	}

	public Produto salvarProduto(Long codigoCategoria, Produto produto) {

		validarCategoriaDoProdutoExiste(codigoCategoria);
		validarProdutoDuplicado(produto);
		return produtoRepository.save(produto);

	}

	public Produto atualizarProduto(Long codigoCategoria, Long codigoProduto, Produto produto) {

		Produto produtoSalvar = validarProdutoExiste(codigoProduto, codigoCategoria);
		validarCategoriaDoProdutoExiste(codigoCategoria);
		validarProdutoDuplicado(produto);
		BeanUtils.copyProperties(produto, produtoSalvar, "codigo");
		return produtoRepository.save(produtoSalvar);

	}
	
	public void deletarProduto(Long codigoCategoria, Long codigoProduto) {
		
		Produto produto = validarProdutoExiste(codigoProduto, codigoCategoria);
		produtoRepository.delete(produto);
	}
	
	protected void atualizarQuantidadeEmEstoque(Produto produto) {
		
		produtoRepository.save(produto);
	}
	
	protected Produto validarProdutoExiste(Long codigoProduto) {

		Optional<Produto> produto = produtoRepository.findById(codigoProduto);
		if (produto.isEmpty()) {

			throw new RegraNegocioExeption(String.format("Produto de código %s não encontrado", codigoProduto));

		}
		return produto.get();
		

	}

	private Produto validarProdutoExiste(Long codigoProduto, Long codigoCategoria) {

		Optional<Produto> produto = buscarPorCodigo(codigoProduto, codigoCategoria);
		if (produto.isEmpty()) {

			throw new EmptyResultDataAccessException(1);

		}
		return produto.get();
		

	}

	private void validarProdutoDuplicado(Produto produto) {
		
		Optional<Produto> produtoPorDescricao = produtoRepository
		.findByCategoriaCodigoAndDescricao(produto.getCategoria().getCodigo(), produto.getDescricao());

		if (produtoPorDescricao.isPresent() && produtoPorDescricao.get().getCodigo()!= produto.getCodigo()) {

			throw new RegraNegocioExeption(String.format("O produto %s já está cadastrado ", produto.getDescricao()));

		}

	}

	private void validarCategoriaDoProdutoExiste(Long codigoCategoria) {

		if (codigoCategoria == null) {

			throw new RegraNegocioExeption("A categoria não pode ser nula");

		}

		if (categoriaService.buscarPorCodigo(codigoCategoria).isEmpty()) {

			throw new RegraNegocioExeption(
					String.format("A categoria de código %s informada não existe no cadastro", codigoCategoria));

		}

	}

}
