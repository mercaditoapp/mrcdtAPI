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
@Table(name = "PASO")
public class Paso {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "INDICE")
	private Integer indice;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "PROCEDIMIENTO_IDX")
	private Procedimiento procedimiento;

	public Paso() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	@Override
	public String toString() {
		return "Paso [idx=" + idx + ", descripcion=" + descripcion + ", indice=" + indice + ", procedimiento="
				+ procedimiento + "]";
	}

}
