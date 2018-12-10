package com.uae.biblioteca.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="prestamo")
public class Prestamo {
	
	@Id
	private int idPrestamo;
	private Date fecha_prestamo;
	private Date fecha_devolucion;
	private BigDecimal monto_mora;
	private String carnet_estudiante;
	private String nombre_encargado;
	private Date fecha_creacion;
	
	@JoinColumn(name="idLibro", referencedColumnName = "idLibro")
	@ManyToOne
	private Libro idLibro;
	
	@JoinColumn(name="idAutor", referencedColumnName = "idAutor")
	@ManyToOne
	private Autor idAutor;
	
	@JoinColumn(name="idEditorial", referencedColumnName = "idEditorial")
	@ManyToOne
	private Editorial idEditorial;
	
	
	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}
	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	public BigDecimal getMonto_mora() {
		return monto_mora;
	}
	public void setMonto_mora(BigDecimal monto_mora) {
		this.monto_mora = monto_mora;
	}
	public String getCarnet_estudiante() {
		return carnet_estudiante;
	}
	public void setCarnet_estudiante(String carnet_estudiante) {
		this.carnet_estudiante = carnet_estudiante;
	}
	public String getNombre_encargado() {
		return nombre_encargado;
	}
	public void setNombre_encargado(String nombre_encargado) {
		this.nombre_encargado = nombre_encargado;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Libro getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Libro idLibro) {
		this.idLibro = idLibro;
	}
	public Autor getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Autor idAutor) {
		this.idAutor = idAutor;
	}
	public Editorial getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(Editorial idEditorial) {
		this.idEditorial = idEditorial;
	}
	public Prestamo(int idPrestamo, Date fecha_prestamo, Date fecha_devolucion, BigDecimal monto_mora,
			String carnet_estudiante, String nombre_encargado, Date fecha_creacion, Libro idLibro, Autor idAutor,
			Editorial idEditorial) {
		super();
		this.idPrestamo = idPrestamo;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
		this.monto_mora = monto_mora;
		this.carnet_estudiante = carnet_estudiante;
		this.nombre_encargado = nombre_encargado;
		this.fecha_creacion = fecha_creacion;
		this.idLibro = idLibro;
		this.idAutor = idAutor;
		this.idEditorial = idEditorial;
	}
	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	
	
	
	
}
