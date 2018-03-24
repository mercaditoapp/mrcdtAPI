package io.mercadito.api.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "PRECIO")
	private String precio;

	@Column(name = "IMAGEN")
	private String imagen;

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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return " >>> Producto [idx=" + idx + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen + "]";
	}

}
