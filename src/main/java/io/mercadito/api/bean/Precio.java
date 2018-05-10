package io.mercadito.api.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRECIO")
public class Precio {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "PRECIO_MV")
	private Float precioMv;

	@Column(name = "PRECIO_BASE")
	private Float precioBase;

	@ManyToOne
	@JoinColumn(name = "ESCALAR_BASE_IDX")
	private Escalar escalarBase;

	@ManyToOne
	@JoinColumn(name = "ESCALAR_PRESENTACION_MV_IDX")
	private Escalar escalarPresentacionMv;

	@ManyToOne
	@JoinColumn(name = "ESCALAR_CONTENIDO_MV_IDX")
	private Escalar escalarContenidoMv;

	@ManyToOne
	@JoinColumn(name = "ALMACEN_IDX")
	private Almacen almacen;

	@ManyToOne
	@JoinColumn(name = "PRODUCTO_IDX")
	private Producto producto;

	public Precio() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Float getPrecioMv() {
		return precioMv;
	}

	public void setPrecioMv(Float precioMv) {
		this.precioMv = precioMv;
	}

	public Float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Float precioBase) {
		this.precioBase = precioBase;
	}

	public Escalar getEscalarBase() {
		return escalarBase;
	}

	public void setEscalarBase(Escalar escalarBase) {
		this.escalarBase = escalarBase;
	}

	public Escalar getEscalarPresentacionMv() {
		return escalarPresentacionMv;
	}

	public void setEscalarPresentacionMv(Escalar escalarPresentacionMv) {
		this.escalarPresentacionMv = escalarPresentacionMv;
	}

	public Escalar getEscalarContenidoMv() {
		return escalarContenidoMv;
	}

	public void setEscalarContenidoMv(Escalar escalarContenidoMv) {
		this.escalarContenidoMv = escalarContenidoMv;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
