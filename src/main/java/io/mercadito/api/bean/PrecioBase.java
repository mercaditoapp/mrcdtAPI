package io.mercadito.api.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PRECIO_BASE")
public class PrecioBase {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "PRECIO")
	private Float precio;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "PRODUCTO_IDX")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "ESCALAR_IDX")
	private Escalar escalar;

	public PrecioBase() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Escalar getEscalar() {
		return escalar;
	}

	public void setEscalar(Escalar escalar) {
		this.escalar = escalar;
	}

}
