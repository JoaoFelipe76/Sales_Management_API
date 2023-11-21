package com.speedware.gestaovendas.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "data")
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo")
	private Cliente cliente;

	public Venda(LocalDate data, Cliente cliente) {

		this.data = data;
		this.cliente = cliente;
	}

	public Venda(Long codigo, LocalDate data, Cliente cliente) {

		this.codigo = codigo;
		this.data = data;
		this.cliente = cliente;
	}

	public Venda() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, codigo, data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(data, other.data);
	}

}
