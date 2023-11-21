package com.speedware.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Venda requisição DTO")
public class VendaRequestDTO {
	
	@Schema(name = "Data")
	@NotNull(message = "Data")
	private LocalDate data;
	
	@Schema(name = "Itens da venda")
	@NotNull(message = "Itens venda")
	private List<itemVendaRequestDTO> itensVendaDto;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<itemVendaRequestDTO> getItensVendaDto() {
		return itensVendaDto;
	}

	public void setItensVendaDto(List<itemVendaRequestDTO> itensVendaDto) {
		this.itensVendaDto = itensVendaDto;
	}
	
	
	

}
