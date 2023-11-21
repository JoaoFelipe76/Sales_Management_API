package com.speedware.gestaovendas.dto.venda;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Cliente da venda retorno DTO")
public class ClienteVendaResponseDTO {

	@Schema(name = "Nome cliente")
	private String nome;

	@Schema(name = "Venda")
	private List<VendaResponseDTO> vendaResponseDTOs;

	public ClienteVendaResponseDTO(String nome, List<VendaResponseDTO> vendaResponseDTOs) {

		this.nome = nome;
		this.vendaResponseDTOs = vendaResponseDTOs;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<VendaResponseDTO> getVendaResponseDTOs() {
		return vendaResponseDTOs;
	}

	public void setVendaResponseDTOs(List<VendaResponseDTO> vendaResponseDTOs) {
		this.vendaResponseDTOs = vendaResponseDTOs;
	}

}
