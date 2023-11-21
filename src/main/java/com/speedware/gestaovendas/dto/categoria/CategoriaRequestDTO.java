package com.speedware.gestaovendas.dto.categoria;

import org.hibernate.validator.constraints.Length;

import com.speedware.gestaovendas.entities.Categoria;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "Categoria requisição DTO")
public class CategoriaRequestDTO {
	
	@Schema(name = "Nome")
	@NotBlank(message = "nome")
	@Length(min = 3, max = 50, message = "Nome")
	private String nome;
	
	public Categoria converterParaEntidade() {
		
		return new Categoria(nome);
		
		
	}
	
	public Categoria converterParaEntidade(Long codigo) {
		
		return new Categoria(codigo, nome);
		
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	


}
