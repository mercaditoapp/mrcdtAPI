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
@Table(name = "PRECIO_MINIMO_VENTA")
public class PrecioMinimoVenta {

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
	@JoinColumn(name = "ESCALAR_PRESENTACION_IDX")
	private Escalar escalarPresentacion;

	@ManyToOne
	@JoinColumn(name = "ESCALAR_CONTENIDO_IDX")
	private Escalar escalarContenido;

	public PrecioMinimoVenta() {

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

	public Escalar getEscalarPresentacion() {
		return escalarPresentacion;
	}

	public void setEscalarPresentacion(Escalar escalarPresentacion) {
		this.escalarPresentacion = escalarPresentacion;
	}

	public Escalar getEscalarContenido() {
		return escalarContenido;
	}

	public void setEscalarContenido(Escalar escalarContenido) {
		this.escalarContenido = escalarContenido;
	}

}
