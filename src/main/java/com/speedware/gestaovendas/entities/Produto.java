package com.speedware.gestaovendas.entities;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco_custo")
	private BigDecimal precoCusto;

	@Column(name = "preco_venda")
	private BigDecimal precoVenda;

	@Column(name = "observacao")
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
	private Categoria categoria;

	public Produto() {

	}

	public Produto(Long codigo, String descricao, Integer quantidade, BigDecimal precoCusto, BigDecimal precoVenda,
			String observacao, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.observacao = observacao;
		this.categoria = categoria;
	}

	public Produto(String descricao, Integer quantidade, BigDecimal precoCusto, BigDecimal precoVenda,
			String observacao, Categoria categoria) {

		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.observacao = observacao;
		this.categoria = categoria;
	}

	public Produto(Long codigo) {

		this.codigo = codigo;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
