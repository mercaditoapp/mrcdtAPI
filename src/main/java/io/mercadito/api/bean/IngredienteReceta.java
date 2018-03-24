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
@Table(name = "INGREDIENTE_RECETA")
public class IngredienteReceta {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "CANTIDAD")
	private Float cantidad;

	@ManyToOne
	@JoinColumn(name = "PRODUCTO_IDX")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "UNIDAD_IDX")
	private Unidad unidad;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "RECETA_IDX")
	private Receta receta;

	public IngredienteReceta() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public String toString() {
		return "IngredienteReceta [idx=" + idx + ", cantidad=" + cantidad + ", producto=" + producto + ", unidad="
				+ unidad + ", receta=" + receta + "]";
	}

}
