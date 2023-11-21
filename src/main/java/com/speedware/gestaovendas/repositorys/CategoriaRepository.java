package com.speedware.gestaovendas.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.speedware.gestaovendas.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


	List<Categoria> findByNome(String nome);
	
}
