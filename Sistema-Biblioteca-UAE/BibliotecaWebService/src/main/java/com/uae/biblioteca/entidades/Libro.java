package com.uae.biblioteca.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table (name="libro")
public class Libro {
	
	@Id
	@GeneratedValue
	private  int idLibro;
	private String titulo;
	private int edicion;
	private int fecha_publicacion;
	private String isbn;
	private int numero_paginas;
	private int codigo;
	private String condicion_fisica;
	private int estado;
	private String comentario;
	
	@JoinColumn(name="idAutor", referencedColumnName = "idAutor")
	@ManyToOne
	private Autor idAutor;
	@JoinColumn(name="idCategoria", referencedColumnName = "idCategoria")
	@ManyToOne
	private Categoria idCategoria;
	@JoinColumn(name="idEditorial", referencedColumnName = "idEditorial")
	@ManyToOne
	private Editorial idEditorial;
	
	
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getEdicion() {
		return edicion;
	}
	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}
	public int getFecha_publicacion() {
		return fecha_publicacion;
	}
	public void setFecha_publicacion(int fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNumero_paginas() {
		return numero_paginas;
	}
	public void setNumero_paginas(int numero_paginas) {
		this.numero_paginas = numero_paginas;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCondicion_fisica() {
		return condicion_fisica;
	}
	public void setCondicion_fisica(String condicion_fisica) {
		this.condicion_fisica = condicion_fisica;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Autor getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Autor idAutor) {
		this.idAutor = idAutor;
	}
	public Categoria getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Editorial getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(Editorial idEditorial) {
		this.idEditorial = idEditorial;
	}
	public Libro(int idLibro, String titulo, int edicion, int fecha_publicacion, String isbn, int numero_paginas,
			int codigo, String condicion_fisica, int estado, String comentario, Autor idAutor, Categoria idCategoria,
			Editorial idEditorial) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.edicion = edicion;
		this.fecha_publicacion = fecha_publicacion;
		this.isbn = isbn;
		this.numero_paginas = numero_paginas;
		this.codigo = codigo;
		this.condicion_fisica = condicion_fisica;
		this.estado = estado;
		this.comentario = comentario;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
		this.idEditorial = idEditorial;
	}
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	

}
