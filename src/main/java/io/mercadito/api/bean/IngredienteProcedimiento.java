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
@Table(name = "INGREDIENTE_PROCEDIMIENTO")
public class IngredienteProcedimiento {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "CANTIDAD")
	private Float cantidad;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "PROCEDIMIENTO_IDX")
	private Procedimiento procedimiento;

	@ManyToOne
	@JoinColumn(name = "PRODUCTO_IDX")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "UNIDAD_IDX")
	private Unidad unidad;

	public IngredienteProcedimiento() {

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

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
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
		return " >>> IngredienteProcedimiento [idx=" + idx + ", cantidad=" + cantidad + ", procedimiento=" + procedimiento
				+ ", producto=" + producto + ", unidad=" + unidad + "]";
	}

}
