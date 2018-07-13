package io.mercadito.api.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO_EQUIVALENCIA")
public class ProductoEquivalencia {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@ManyToOne
	@JoinColumn(name = "PRODUCTO_IDX")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "EQUIVALENCIA_IDX")
	private Equivalencia equivalencia;

	@ManyToOne
	@JoinColumn(name = "ALMACEN_IDX")
	private Almacen almacen;

	public ProductoEquivalencia() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Equivalencia getEquivalencia() {
		return equivalencia;
	}

	public void setEquivalencia(Equivalencia equivalencia) {
		this.equivalencia = equivalencia;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

}
