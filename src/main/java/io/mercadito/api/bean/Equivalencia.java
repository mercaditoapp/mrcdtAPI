package io.mercadito.api.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIVALENCIA")
public class Equivalencia {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@ManyToOne
	@JoinColumn(name = "ESCALAR_A_IDX")
	private Escalar escalarA;

	@ManyToOne
	@JoinColumn(name = "ESCALAR_B_IDX")
	private Escalar escalarB;

	public Equivalencia() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Escalar getEscalarA() {
		return escalarA;
	}

	public void setEscalarA(Escalar escalarA) {
		this.escalarA = escalarA;
	}

	public Escalar getEscalarB() {
		return escalarB;
	}

	public void setEscalarB(Escalar escalarB) {
		this.escalarB = escalarB;
	}

}
