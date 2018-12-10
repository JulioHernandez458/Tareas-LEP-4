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

import com.uae.biblioteca.entidades.Categoria;
import com.uae.biblioteca.modelo.CategoriaRepository;


@RestController
@RequestMapping(path="/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaModel;
	
	
	@GetMapping(path="/agregar")
	public String agregarCategoria(
			@RequestParam (value="nombre") String nombre) {
		
		String resultado = "";
		try {
			Categoria categoria = new Categoria();
			categoria.setNombre(nombre);
			
			categoriaModel.save(categoria);
			resultado = "Categoria Ingresada";
			
		} catch  (Exception e) {
			e.printStackTrace();
			resultado = "Error";
		}
		
		return resultado;
	
	}
	

	@GetMapping (path="/get")
	public List<Categoria> getall() {
		List<Categoria> allCategorias = new ArrayList<Categoria>();
		try {
			Iterator<Categoria> iCategoria = categoriaModel.findAll().iterator();
			Categoria  categoria = null;
			while(iCategoria.hasNext()) {
				categoria = iCategoria.next();
				allCategorias.add(categoria);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allCategorias;
	}
	
	@GetMapping(path="/actualizar")
	public String actualizar (
			@RequestParam (value="id") int id ,
			@RequestParam (value="nombre") String nombre) {
		
		String resultado = "";
		try {
			Optional<Categoria> optCategoria = categoriaModel.findById(id);
			if(optCategoria.isPresent()) {
				Categoria categoria = optCategoria.get();
				categoria.setNombre(nombre);
				
				categoriaModel.save(categoria);
				resultado = "Categoria Actualizada";
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
			Optional<Categoria> optCategoria = categoriaModel.findById(id);
			if(optCategoria.isPresent()) {
				Categoria categoria = optCategoria.get();
				
				categoriaModel.delete(categoria);
				resultado = "Categoria Eliminada";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Error";
		}
		
		return resultado;
	}

}
