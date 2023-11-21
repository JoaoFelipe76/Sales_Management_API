package com.speedware.gestaovendas.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.speedware.gestaovendas.entities.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long>{
	
	@Query("SELECT new com.speedware.gestaovendas.entities.ItemVenda(iv.codigo, iv.quantidade, iv.precoVendido, iv.produto, iv.venda) " +
		       "FROM ItemVenda iv " +
		       "WHERE iv.venda.codigo = :codigoVenda")
	List<ItemVenda> findByVendaPorCodigo(Long codigoVenda);

}
