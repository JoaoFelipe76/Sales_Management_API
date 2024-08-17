package com.speedware.gestaovendas.dto.produto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.speedware.gestaovendas.entities.Categoria;
import com.speedware.gestaovendas.entities.Produto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Schema(name = "Produto requisição DTO")
public class ProdutoRequestDTO {

	@Schema(name = "Descrição")
	@NotBlank(message = "Descrição")
	@Length(min = 3, max = 100, message = "Descrição")
	private String descricao;

	@Schema(name = "Quantidade")
	@NotNull(message = "Quantidade")
	private Integer quantidade;

	@Schema(name = "Preço Custo")
	@NotNull(message = "Preço custo")
	private BigDecimal precoCusto;

	@Schema(name = "Preço Venda")
	@NotNull(message = "Preço venda")
	private BigDecimal precoVenda;

	@Schema(name = "Observação")
	@Length(max = 500, message = "Observação")
	private String observacao;

	public Produto converterParaEntidade(Long codigoCategoria) {
		return new Produto(descricao, quantidade, precoCusto, precoVenda, observacao, new Categoria(codigoCategoria));
	}

	public Produto converterParaEntidade(Long codigoCategoria, Long codigoProduto) {
		return new Produto(codigoProduto, descricao, quantidade, precoCusto, precoVenda, observacao, new Categoria(codigoCategoria));
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

}
