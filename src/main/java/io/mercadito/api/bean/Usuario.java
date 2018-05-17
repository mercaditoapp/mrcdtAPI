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
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDOS")
	private Integer apellidos;

	@Column(name = "EMAIL")
	private Integer email;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "PERFIL_IDX")
	private Procedimiento perfil;

	public Usuario() {

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

	public Integer getApellidos() {
		return apellidos;
	}

	public void setApellidos(Integer apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEmail() {
		return email;
	}

	public void setEmail(Integer email) {
		this.email = email;
	}

	public Procedimiento getPerfil() {
		return perfil;
	}

	public void setPerfil(Procedimiento perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [idx=" + idx + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", perfil=" + perfil + "]";
	}

}
