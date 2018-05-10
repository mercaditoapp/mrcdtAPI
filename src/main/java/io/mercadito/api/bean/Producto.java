package io.mercadito.api.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "IMAGEN")
	private String imagen;

	@JsonManagedReference
	@OneToMany(mappedBy = "producto")
	private List<PrecioMinimoVenta> precioMinimoVenta;

	@JsonManagedReference
	@OneToMany(mappedBy = "producto")
	private List<PrecioBase> precioBase;

	public Producto() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<PrecioMinimoVenta> getPrecioMinimoVenta() {
		return precioMinimoVenta;
	}

	public void setPrecioMinimoVenta(List<PrecioMinimoVenta> precioMinimoVenta) {
		this.precioMinimoVenta = precioMinimoVenta;
	}

}
