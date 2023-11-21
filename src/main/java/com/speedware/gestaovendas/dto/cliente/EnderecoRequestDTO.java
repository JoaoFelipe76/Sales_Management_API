package com.speedware.gestaovendas.dto.cliente;

import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(name = "Endereço requisição DTO")
public class EnderecoRequestDTO {
	
	@Schema(name = "Logradouro")
	@NotBlank(message = "Nome")
	@Length(min = 5, max = 30, message = "Nome")
	private String logradouro;

	@Schema(name = "Número")
	@NotNull(message = "Número")
	private Integer numero;

	@Schema(name = "Complemento")
	@Length(min = 3, max = 30, message = "Complemento")
	private String complemento;

	@Schema(name = "Bairro")
	@NotBlank(message = "Bairro")
	@Length(min = 5, max = 30, message = "Bairro")
	private String bairro;

	@Schema(name = "Cep")
	@NotBlank(message = "Cep")
	@Pattern(regexp =  "[\\d]{5}-[\\d]{3}", message = "Cep")
	private String cep;

	@Schema(name = "Cidade")
	@NotBlank(message = "Cidade")
	@Length(min = 5, max = 30, message = "Cidade")
	private String cidade;

	@Schema(name = "Estado")
	@NotBlank(message = "Estado")
	@Length(min = 5, max = 30, message = "Estado")
	private String estado;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	


}
