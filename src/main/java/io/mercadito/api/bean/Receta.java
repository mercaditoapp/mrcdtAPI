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
@Table(name = "RECETA")
public class Receta {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "IDX")
	private Integer idx;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "NOMBRE_URL")
	private String nombreUrl;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "IMAGEN")
	private String imagen;

	@Column(name = "PRECIO")
	private String precio;

	@Column(name = "PORCIONES")
	private String porciones;

	@Column(name = "TIEMPO_PREPARACION")
	private String tiempoPreparacion;

	@JsonManagedReference
	@OneToMany(mappedBy = "receta")
	private List<IngredienteReceta> ingredientesReceta;

	@JsonManagedReference
	@OneToMany(mappedBy = "receta")
	private List<Procedimiento> procedimientos;

	public Receta() {

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

	public String getNombreUrl() {
		return nombreUrl;
	}

	public void setNombreUrl(String nombreUrl) {
		this.nombreUrl = nombreUrl;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getPorciones() {
		return porciones;
	}

	public void setPorciones(String porciones) {
		this.porciones = porciones;
	}

	public String getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(String tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	public List<Procedimiento> getProcedimientos() {
		return procedimientos;
	}

	public void setProcedimientos(List<Procedimiento> procedimientos) {
		this.procedimientos = procedimientos;
	}

	public List<IngredienteReceta> getIngredientesReceta() {
		return ingredientesReceta;
	}

	public void setIngredientesReceta(List<IngredienteReceta> ingredientesReceta) {
		this.ingredientesReceta = ingredientesReceta;
	}

	@Override
	public String toString() {
		return "Receta [idx=" + idx + ", nombre=" + nombre + ", nombreUrl=" + nombreUrl + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", precio=" + precio + ", porciones=" + porciones + ", tiempoPreparacion="
				+ tiempoPreparacion + ", ingredientesReceta=" + ingredientesReceta + ", procedimientos="
				+ procedimientos + "]";
	}

}
