package com.speedware.gestaovendas.dto.venda;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Itens da venda requisição DTO")
public class itemVendaRequestDTO {

	@Schema(name = "Código produto")
	@NotNull(message = "Código produto")
	private Long codigoProduto;

	@Schema(name = "Quantidade")
	@NotNull(message = "Quantidade")
	@Min(value = 1, message = "Quantidade")
	private Integer quantidade;

	@Schema(name = "Preço Vendido")
	@NotNull(message = "Preço vendido")
	private BigDecimal precoVendido;

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoVendido() {
		return precoVendido;
	}

	public void setPrecoVendido(BigDecimal precoVendido) {
		this.precoVendido = precoVendido;
	}

}
