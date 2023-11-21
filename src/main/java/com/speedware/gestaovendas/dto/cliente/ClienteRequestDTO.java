package com.speedware.gestaovendas.dto.cliente;

import org.hibernate.validator.constraints.Length;

import com.speedware.gestaovendas.entities.Cliente;
import com.speedware.gestaovendas.entities.Endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(name = "Cliente requisição DTO")
public class ClienteRequestDTO {
	
	@Schema(name = "Nome")
	@NotBlank(message = "Nome")
	@Length(min = 5, max = 50, message = "Nome")
	private String nome;

	@Schema(name = "Telefone")
	@NotBlank(message = "Telefone")
	@Pattern(regexp = "\\([\\d]{2}\\)[\\d]{5}[- .][\\d]{4}", message = "Telefone")
	private String telefone;

	@Schema(name = "Ativo")
	@NotNull(message = "Ativo")
	private Boolean ativo;
	
	@Schema(name = "Endereço")
	@NotNull(message = "Endereço")
	@Valid
	private EnderecoResponseDTO enderecoDto;
	
	public Cliente converterParaEntidade() {
		Endereco endereco = new Endereco(enderecoDto.getLogradouro(), enderecoDto.getNumero(), enderecoDto.getComplemento(), enderecoDto.getBairro(), enderecoDto.getCep(), enderecoDto.getCidade(), enderecoDto.getEstado());
		return new Cliente(nome, telefone, ativo, endereco);
		
	}
	
	public Cliente converterParaEntidade(Long codigo) {
		Endereco endereco = new Endereco(enderecoDto.getLogradouro(), enderecoDto.getNumero(), enderecoDto.getComplemento(), enderecoDto.getBairro(), enderecoDto.getCep(), enderecoDto.getCidade(), enderecoDto.getEstado());
		return new Cliente(codigo, nome, telefone, ativo, endereco);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public EnderecoResponseDTO getEnderecoDto() {
		return enderecoDto;
	}

	public void setEnderecoDto(EnderecoResponseDTO enderecoDto) {
		this.enderecoDto = enderecoDto;
	}
	
	

}
