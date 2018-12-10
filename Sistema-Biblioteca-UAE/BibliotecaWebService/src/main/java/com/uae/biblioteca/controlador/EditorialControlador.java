package com.uae.biblioteca.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uae.biblioteca.entidades.Editorial;
import com.uae.biblioteca.modelo.EditorialRepository;

@RestController
@RequestMapping(path="/editorial")
public class EditorialControlador {
	
	
	@Autowired
	private EditorialRepository editorialModel;
	
	
	@GetMapping(path="/agregar")
	public String agregarEditorial(
			@RequestParam (value="nombre", defaultValue="") String nombre,
			@RequestParam (value="direccion", defaultValue="") String direccion,
			@RequestParam (value="telefono", defaultValue="") String telefono,
			@RequestParam (value="contacto", defaultValue="") String contacto) {
		String resultado = "";
		
		try {
			
			Editorial editorial = new Editorial(0,nombre,direccion,telefono,contacto);
			
			editorialModel.save(editorial);
			resultado = "Editorial Ingresada";
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Error";
		}
		
		
		
		return resultado;
	}
	
	
	@GetMapping (path="/get")
	public List<Editorial> getall(){
		
		List <Editorial> alleditoriales = new ArrayList <Editorial>();
		Editorial editorial = null;
		try {
			
			Iterator <Editorial> iEditorial = editorialModel.findAll().iterator();
			while(iEditorial.hasNext()) {
				editorial = iEditorial.next();
				alleditoriales.add(editorial);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return alleditoriales;
	}
	
	
	
	@GetMapping(path="/actualizar")
	public String actualizar (
			@RequestParam (value="id", defaultValue="0") int id,
			@RequestParam (value="nombre", defaultValue="") String nombre,
			@RequestParam (value="direccion", defaultValue="") String direccion,
			@RequestParam (value="telefono", defaultValue="") String telefono,
			@RequestParam (value="contacto", defaultValue="") String contacto) {
		
		String resultado = "";
		try {
			Optional <Editorial> optEditorial = editorialModel.findById(id);
			if(optEditorial.isPresent()) {
				Editorial editorial = optEditorial.get();
				
				editorial.setNombre(nombre);
				editorial.setDireccion(direccion);
				editorial.setTelefono(telefono);
				editorial.setContacto(contacto);
				
				editorialModel.save(editorial);
				resultado = "Editorial Actualizada";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Error";
		}
		
		
		return resultado;
	}
	
	@GetMapping(path="/eliminar")
	public String eliminar(@RequestParam (value="id") int id) {
		
		String resultado = "";
		
		try {
			
			Optional <Editorial> optEditorial = editorialModel.findById(id);
			Editorial editorial = null;
			
			if(optEditorial.isPresent()) {
				editorial = optEditorial.get();
			
				editorialModel.delete(editorial);
				resultado = "Editorial Eliminada";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Error";
		}
		
		return resultado;
	}
	

}
