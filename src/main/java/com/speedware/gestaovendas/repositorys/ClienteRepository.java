package com.speedware.gestaovendas.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.speedware.gestaovendas.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByNome(String nome);
	
}
