package com.uae.biblioteca.controlador;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uae.biblioteca.entidades.Autor;
import com.uae.biblioteca.entidades.Editorial;
import com.uae.biblioteca.entidades.Libro;
import com.uae.biblioteca.entidades.Prestamo;
import com.uae.biblioteca.modelo.AutorRepository;
import com.uae.biblioteca.modelo.EditorialRepository;
import com.uae.biblioteca.modelo.LibroRepository;
import com.uae.biblioteca.modelo.PrestamoRepository;

@RestController
@RequestMapping(path="/prestamo")
public class PrestamoControlador {
	
	@Autowired
    private PrestamoRepository prestamoModel;
	
	@Autowired
    private LibroRepository libroModel;
	
	@Autowired
    private AutorRepository autorModel;
	
	@Autowired
    private EditorialRepository editorialModel;
	
	@GetMapping(path="/agregar")
	public String agregarPrestamo(
			@RequestParam (value="fprestamo", defaultValue="") Date fprestamo,
			@RequestParam (value="fdevolucion", defaultValue="") Date fdevolucion,
			@RequestParam (value="mora", defaultValue="") BigDecimal mora,
			@RequestParam (value="carnet", defaultValue="") String carnet,
			@RequestParam (value="encargado", defaultValue="") String encargado,
			@RequestParam (value="fcreacion", defaultValue="") Date fcreacion,
			@RequestParam (value="idlibro", defaultValue="0") int idlibro,
			@RequestParam (value="idautor", defaultValue="0") int idautor,
			@RequestParam (value="ideditorial", defaultValue="0") int ideditorial) {
		
		String resultado = "";
		try {
			
			Optional <Libro> libro = libroModel.findById(idlibro);
			Optional <Autor> autor = autorModel.findById(idautor);
			Optional <Editorial> editorial = editorialModel.findById(ideditorial);
			
			Prestamo prestamo = new Prestamo(0,fprestamo,fdevolucion,mora,
					carnet,encargado,fcreacion,libro.get(),autor.get(),
					editorial.get());
			
			prestamoModel.save(prestamo);
			resultado = "Prestamo Ingresado";
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Error";
		}
		
		return resultado;
	}
	
	
	
	@GetMapping (path="/get")
	public List<Prestamo> getall(){
		
		List<Prestamo> allprestamos = new ArrayList<Prestamo>();
		
		try {
			
			Iterator <Prestamo> iPrestamo = prestamoModel.findAll().iterator();
			
			Prestamo prestamo = null;
			while(iPrestamo.hasNext()) {
				prestamo = iPrestamo.next();
				allprestamos.add(prestamo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allprestamos;
		
	}
	
	@GetMapping(path="/actualizar")
	public String actualizar (
			@RequestParam (value="id", defaultValue="0") int id,
			@RequestParam (value="fprestamo", defaultValue="") Date fprestamo,
			@RequestParam (value="fdevolucion", defaultValue="") Date fdevolucion,
			@RequestParam (value="mora", defaultValue="") BigDecimal mora,
			@RequestParam (value="carnet", defaultValue="") String carnet,
			@RequestParam (value="encargado", defaultValue="") String encargado,
			@RequestParam (value="fcreacion", defaultValue="") Date fcreacion,
			@RequestParam (value="idlibro", defaultValue="0") int idlibro,
			@RequestParam (value="idautor", defaultValue="0") int idautor,
			@RequestParam (value="ideditorial", defaultValue="0") int ideditorial) {
		
		String resultado = "";
		try {
			
			/*Optional <Prestamo> optPrestamo = prestamoModel.findById(id);
			
			if(optPrestamo.isPresent()) {
				Prestamo prestamo = optPrestamo.get();
				
			}*/
			Optional <Libro> libro = libroModel.findById(idlibro);
			Optional <Autor> autor = autorModel.findById(idautor);
			Optional <Editorial> editorial = editorialModel.findById(ideditorial);
			
			Prestamo prestamo = new Prestamo(id,fprestamo,fdevolucion,mora,
					carnet,encargado,fcreacion,libro.get(),autor.get(),
					editorial.get());
			
			prestamoModel.save(prestamo);
			resultado = "Prestamo Actualizado";
			
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
			
			Optional <Prestamo> optPrestamo = prestamoModel.findById(id);
			
			if(optPrestamo.isPresent()) {
				Prestamo prestamo = optPrestamo.get();
				
				prestamoModel.delete(prestamo);
				resultado = "Prestamo Eliminado";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "Error";
		}
		
		
		return resultado;
	}

}
