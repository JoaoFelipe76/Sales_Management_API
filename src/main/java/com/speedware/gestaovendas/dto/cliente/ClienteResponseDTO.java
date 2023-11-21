package com.speedware.gestaovendas.dto.cliente;

import com.speedware.gestaovendas.entities.Cliente;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Cliente retorno DTO")
public class ClienteResponseDTO {

	@Schema(name = "Código")
	private Long codigo;

	@Schema(name = "Nome")
	private String nome;

	@Schema(name = "Telefone")
	private String telefone;

	@Schema(name = "Ativo")
	private Boolean ativo;

	private EnderecoResponseDTO enderecoDto;

	public ClienteResponseDTO(Long codigo, String nome, String telefone, Boolean ativo,
			EnderecoResponseDTO enderecoDto) {

		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.ativo = ativo;
		this.enderecoDto = enderecoDto;
	}

	public static ClienteResponseDTO covereterParaClienteDTO(Cliente cliente) {

		EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO(cliente.getEndereco().getLogradouro(),
				cliente.getEndereco().getNumero(), cliente.getEndereco().getComplemento(),
				cliente.getEndereco().getBairro(), cliente.getEndereco().getCep(), cliente.getEndereco().getCidade(),
				cliente.getEndereco().getEstado());

		return new ClienteResponseDTO(cliente.getCodigo(), cliente.getNome(), cliente.getTelefone(), cliente.getAtivo(),
				enderecoResponseDTO);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
