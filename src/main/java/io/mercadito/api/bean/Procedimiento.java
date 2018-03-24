package io.mercadito.api.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PROCEDIMIENTO")
public class Procedimiento {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "INDICE")
	private Integer indice;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "NOMBRE_TAB")
	private String nombreTab;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "RECETA_IDX")
	private Receta receta;

	@JsonManagedReference
	@OneToMany(mappedBy = "procedimiento")
	private List<Paso> pasos;

	@JsonManagedReference
	@OneToMany(mappedBy = "procedimiento")
	private List<IngredienteProcedimiento> ingredientesProcedimiento;

	public Procedimiento() {

	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public List<Paso> getPasos() {
		return pasos;
	}

	public void setPasos(List<Paso> pasos) {
		this.pasos = pasos;
	}

	public List<IngredienteProcedimiento> getIngredientesProcedimiento() {
		return ingredientesProcedimiento;
	}

	public void setIngredientesProcedimiento(List<IngredienteProcedimiento> ingredientesProcedimiento) {
		this.ingredientesProcedimiento = ingredientesProcedimiento;
	}

	public String getNombreTab() {
		return nombreTab;
	}

	public void setNombreTab(String nombreTab) {
		this.nombreTab = nombreTab;
	}

	@Override
	public String toString() {
		return "Procedimiento [idx=" + idx + ", indice=" + indice + ", nombre=" + nombre + ", nombreTab=" + nombreTab
				+ ", receta=" + receta + ", pasos=" + pasos + ", ingredientesProcedimiento=" + ingredientesProcedimiento
				+ "]";
	}

}
