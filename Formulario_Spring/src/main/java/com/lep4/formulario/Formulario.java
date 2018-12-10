package com.lep4.formulario;

public class Formulario {
	

	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Formulario(int id, String nombre, String apellido, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	public Formulario() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "id: "+ this.id + ", nombre: "+ this.nombre 
				+", apellido: " + this.apellido + ", edad: "+ this.edad;

	}


}
