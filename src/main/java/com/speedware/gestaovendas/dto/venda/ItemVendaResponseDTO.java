package com.speedware.gestaovendas.dto.venda;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Itens venda retorno DTO")
public class ItemVendaResponseDTO {

	@Schema(name = "Codigo")
	private Long codigo;

	@Schema(name = "Quantidade")
	private Integer quantidade;

	@Schema(name = "Preço vendido")
	private BigDecimal precoVendido;

	@Schema(name = "Código produto")
	private Long codigoProduto;

	@Schema(name = "Descrição produto")
	private String produtoDescricao;

	public ItemVendaResponseDTO(Long codigo, Integer quantidade, BigDecimal precoVendido, Long codigoProduto,
			String produtoDescricao) {

		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoVendido = precoVendido;
		this.codigoProduto = codigoProduto;
		this.produtoDescricao = produtoDescricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

}
