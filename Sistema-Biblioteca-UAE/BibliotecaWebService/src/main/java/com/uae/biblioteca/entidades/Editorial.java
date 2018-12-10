package com.uae.biblioteca.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="editorial")
public class Editorial {

	@Id
	@GeneratedValue
	private int idEditorial;
	private String nombre;
	private String direccion;
	private String telefono;
	private String contacto;
	
	
	
	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public Editorial(int idEditorial, String nombre, String direccion, String telefono, String contacto) {
		super();
		this.idEditorial = idEditorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
	}
	public Editorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
