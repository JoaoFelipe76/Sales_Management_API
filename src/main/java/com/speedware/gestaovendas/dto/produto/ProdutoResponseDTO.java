package com.speedware.gestaovendas.dto.produto;

import java.math.BigDecimal;

import com.speedware.gestaovendas.dto.categoria.CategoriaResponseDTO;
import com.speedware.gestaovendas.entities.Produto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Produto retorno DTO")
public class ProdutoResponseDTO {

	@Schema(name = "Código")
	private Long codigo;

	@Schema(name = "Descrição")
	private String descricao;

	@Schema(name = "Quantidade")
	private Integer quantidade;

	@Schema(name = "Preço Custo")
	private BigDecimal precoCusto;

	@Schema(name = "Preço Venda")
	private BigDecimal precoVenda;

	@Schema(name = "Observção")
	private String observacao;

	@Schema(name = "Categoria")
	private CategoriaResponseDTO categoria;

	public ProdutoResponseDTO(Long codigo, String descricao, Integer quantidade, BigDecimal precoCusto,
			BigDecimal precoVenda, String observacao, CategoriaResponseDTO categoria) {

		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.observacao = observacao;
		this.categoria = categoria;
	}

	public static ProdutoResponseDTO converterParaProdutoDTO(Produto produto) {

		return new ProdutoResponseDTO(produto.getCodigo(), produto.getDescricao(), produto.getQuantidade(),
				produto.getPrecoCusto(), produto.getPrecoVenda(), produto.getObservacao(),
				CategoriaResponseDTO.converterParaCategoriaDTO(produto.getCategoria()));

	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public CategoriaResponseDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaResponseDTO categoria) {
		this.categoria = categoria;
	}

}
