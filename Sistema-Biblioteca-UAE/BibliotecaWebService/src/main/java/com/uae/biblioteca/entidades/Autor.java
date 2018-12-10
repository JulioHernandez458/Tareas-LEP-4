package com.uae.biblioteca.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="autor")
public class Autor {
	
	@Id
	@GeneratedValue
	private int idAutor;
	private String nombre_completo;
	private String nacionalidad;
	
	
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Autor(int idAutor, String nombre_completo, String nacionalidad) {
		super();
		this.idAutor = idAutor;
		this.nombre_completo = nombre_completo;
		this.nacionalidad = nacionalidad;
	}
	public Autor() {
		// TODO Auto-generated constructor stub
	}
	
	

}
