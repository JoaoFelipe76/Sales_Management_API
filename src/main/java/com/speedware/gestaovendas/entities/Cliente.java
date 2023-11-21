package com.speedware.gestaovendas.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "ativo")
	private Boolean ativo;

	@Embedded
	private Endereco endereco;

	public Cliente() {

	}

	public Cliente(Long codigo, String nome, String telefone, Boolean ativo, Endereco endereco) {

		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.ativo = ativo;
		this.endereco = endereco;
	}

	public Cliente(String nome, String telefone, Boolean ativo, Endereco endereco) {

		this.nome = nome;
		this.telefone = telefone;
		this.ativo = ativo;
		this.endereco = endereco;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, codigo, endereco, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(ativo, other.ativo) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

}
