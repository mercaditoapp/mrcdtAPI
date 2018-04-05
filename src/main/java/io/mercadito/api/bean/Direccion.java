package io.mercadito.api.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECCION")
public class Direccion {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "CALLE")
	private String calle;

	@Column(name = "NUMERO_INTERIOR")
	private String numeroInterior;

	@Column(name = "NUMERO_EXTERIOR")
	private String numeroExterior;

	@Column(name = "COLONIA")
	private String colonia;

	@Column(name = "DELEGACION")
	private String delegacion;

	@Column(name = "CP")
	private String cp;

	public Direccion() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return " >> Direccion [idx=" + idx + ", calle=" + calle + ", numeroInterior=" + numeroInterior
				+ ", numeroExterior=" + numeroExterior + ", colonia=" + colonia + ", delegacion=" + delegacion + ", cp="
				+ cp + "]";
	}

}
