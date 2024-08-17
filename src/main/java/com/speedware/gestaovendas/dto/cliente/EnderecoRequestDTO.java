package com.speedware.gestaovendas.dto.cliente;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Endereço requisição DTO")
public class EnderecoRequestDTO {

    @Schema(name = "Logradouro")
    @NotBlank(message = "Logradouro é obrigatório.")
    private String logradouro;

    @Schema(name = "Número")
    @NotNull(message = "Número é obrigatório.")
    private Integer numero;

    @Schema(name = "Complemento")
    private String complemento;

    @Schema(name = "Bairro")
    @NotBlank(message = "Bairro é obrigatório.")
    private String bairro;

    @Schema(name = "CEP")
    @NotBlank(message = "CEP é obrigatório.")
    private String cep;

    @Schema(name = "Cidade")
    @NotBlank(message = "Cidade é obrigatória.")
    private String cidade;

    @Schema(name = "Estado")
    @NotBlank(message = "Estado é obrigatório.")
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
