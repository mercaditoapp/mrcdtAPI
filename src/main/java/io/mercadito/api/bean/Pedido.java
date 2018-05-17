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
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "FECHA")
	private String fecha;

	@Column(name = "USUARIO_CLIENTE")
	private Integer usuarioClente;

	@Column(name = "USUARIO_OH")
	private Integer usuarioOh;

	@Column(name = "USUARIO_IH")
	private Integer usuarioIh;

	@Column(name = "DRECCION")
	private Integer dreccion;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "PROCEDIMIENTO_IDX")
	private Procedimiento procedimiento;

	public Pedido() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getUsuarioClente() {
		return usuarioClente;
	}

	public void setUsuarioClente(Integer usuarioClente) {
		this.usuarioClente = usuarioClente;
	}

	public Integer getUsuarioOh() {
		return usuarioOh;
	}

	public void setUsuarioOh(Integer usuarioOh) {
		this.usuarioOh = usuarioOh;
	}

	public Integer getUsuarioIh() {
		return usuarioIh;
	}

	public void setUsuarioIh(Integer usuarioIh) {
		this.usuarioIh = usuarioIh;
	}

	public Integer getDreccion() {
		return dreccion;
	}

	public void setDreccion(Integer dreccion) {
		this.dreccion = dreccion;
	}

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	@Override
	public String toString() {
		return "Pedido [idx=" + idx + ", fecha=" + fecha + ", usuarioClente=" + usuarioClente + ", usuarioOh="
				+ usuarioOh + ", usuarioIh=" + usuarioIh + ", dreccion=" + dreccion + ", procedimiento=" + procedimiento
				+ "]";
	}

}
