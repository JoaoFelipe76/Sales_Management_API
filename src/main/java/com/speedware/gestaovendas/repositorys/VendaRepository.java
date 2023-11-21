package com.speedware.gestaovendas.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.speedware.gestaovendas.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

	@Query("SELECT v FROM Venda v WHERE v.cliente = :codigoCliente")
	List<Venda> findByCliente(@Param("codigoCliente") Long codigoCliente);

}
