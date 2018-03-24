package io.mercadito.api.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UNIDAD")
public class Unidad {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "ABREVIATURA")
	private String abreviatura;

	public Unidad() {

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

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	@Override
	public String toString() {
		return " >>> Unidad [idx=" + idx + ", nombre=" + nombre + ", abreviatura=" + abreviatura + "]";
	}

}
