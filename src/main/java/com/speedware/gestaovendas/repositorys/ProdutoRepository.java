package com.speedware.gestaovendas.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.speedware.gestaovendas.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByCategoriaCodigo(Long codigoCategoria);
	
	@Query("SELECT prod FROM Produto prod WHERE prod.codigo = :codigo AND prod.categoria.codigo = :codigoCategoria")
	Optional<Produto> buscarPorCodigo(Long codigo, Long codigoCategoria);
	
	Optional<Produto> findByCategoriaCodigoAndDescricao(Long codigoCategoria, String descricao);


	
	
	
	

}
