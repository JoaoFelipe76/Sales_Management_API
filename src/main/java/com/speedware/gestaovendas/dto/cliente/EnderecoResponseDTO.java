package com.speedware.gestaovendas.dto.cliente;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Endereço retorno DTO")
public class EnderecoResponseDTO {

	@Schema(name = "Logradouro")
	private String logradouro;

	@Schema(name = "Numero")
	private Integer numero;

	@Schema(name = "Complemento")
	private String complemento;

	@Schema(name = "Bairro")
	private String bairro;

	@Schema(name = "Cep")
	private String cep;

	@Schema(name = "Cidade")
	private String cidade;

	@Schema(name = "Estado")
	private String estado;

	public EnderecoResponseDTO(String logradouro, Integer numero, String complemento, String bairro, String cep,
			String cidade, String estado) {

		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

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
