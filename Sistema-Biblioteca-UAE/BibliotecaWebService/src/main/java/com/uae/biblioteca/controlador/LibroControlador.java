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

import com.uae.biblioteca.entidades.Autor;
import com.uae.biblioteca.entidades.Categoria;
import com.uae.biblioteca.entidades.Editorial;
import com.uae.biblioteca.entidades.Libro;
import com.uae.biblioteca.modelo.AutorRepository;
import com.uae.biblioteca.modelo.CategoriaRepository;
import com.uae.biblioteca.modelo.EditorialRepository;
import com.uae.biblioteca.modelo.LibroRepository;


@RestController
@RequestMapping(path="/libro")
public class LibroControlador {
	
	
	    @Autowired
	    private AutorRepository autorModel;
	
		@Autowired
		private LibroRepository libroModel;
		
		@Autowired
		private CategoriaRepository categoriaModel;
		
		@Autowired
		private EditorialRepository editorialModel;
		
		
		@GetMapping(path="/agregar")
		public String agregarCategoria(
				@RequestParam (value="titulo", defaultValue="") String titulo,
				@RequestParam (value="edicion", defaultValue="1") int edicion,
				@RequestParam (value="fecha", defaultValue="0") int fecha,
				@RequestParam (value="isbn", defaultValue="") String isbn,
				@RequestParam (value="paginas", defaultValue="0") int paginas,
				@RequestParam (value="codigo", defaultValue="0") int codigo,
				@RequestParam (value="condicion", defaultValue="") String condicion,
				@RequestParam (value="estado", defaultValue="0") int estado,
				@RequestParam (value="comentario", defaultValue="") String comentario,
				@RequestParam (value="idautor", defaultValue="0") int idautor,
				@RequestParam (value="idcategoria", defaultValue="0") int idcategoria,
				@RequestParam (value="ideditorial", defaultValue="0") int ideditorial) {
			
			String resultado = "";
			try {
				
				Optional <Autor> autor = autorModel.findById(idautor);
				Optional <Categoria> categoria = categoriaModel.findById(idcategoria);
				Optional <Editorial> editorial = editorialModel.findById(ideditorial);
				
				Libro libro = new Libro(0,titulo,edicion,fecha,isbn,paginas,
						codigo,condicion,estado,comentario,autor.get(),categoria.
						get(),editorial.get());
				libroModel.save(libro);
				resultado = "Libro Ingresado";
				
			} catch  (Exception e) {
				e.printStackTrace();
				resultado = "Error";
			}
			
			return resultado;
		
		}
		

		@GetMapping (path="/get")
		public List<Libro> getall() {
			List<Libro> alllibros = new ArrayList<Libro>();
			try {
				Iterator<Libro> iLibro = libroModel.findAll().iterator();
				Libro libro = null;
				while(iLibro.hasNext()) {
					libro = iLibro.next();
					alllibros.add(libro);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return alllibros;
		}
		
		@GetMapping(path="/actualizar")
		public String actualizar (
				@RequestParam (value="id") int idlibro ,
				@RequestParam (value="titulo", defaultValue="") String titulo,
				@RequestParam (value="edicion", defaultValue="1") int edicion,
				@RequestParam (value="fecha", defaultValue="0") int fecha,
				@RequestParam (value="isbn", defaultValue="") String isbn,
				@RequestParam (value="paginas", defaultValue="0") int paginas,
				@RequestParam (value="codigo", defaultValue="0") int codigo,
				@RequestParam (value="condicion", defaultValue="") String condicion,
				@RequestParam (value="estado", defaultValue="0") int estado,
				@RequestParam (value="comentario", defaultValue="") String comentario,
				@RequestParam (value="idautor", defaultValue="0") int idautor,
				@RequestParam (value="idcategoria", defaultValue="0") int idcategoria,
				@RequestParam (value="ideditorial", defaultValue="0") int ideditorial){
			
			String resultado = "";
			try {
				Optional<Libro> optLibro = libroModel.findById(idlibro);
				
				if(optLibro.isPresent()) {
					
					Optional <Autor> autor = autorModel.findById(idautor);
					Optional <Categoria> categoria = categoriaModel.findById(idcategoria);
					Optional <Editorial> editorial = editorialModel.findById(ideditorial);
					
					Libro libro = new Libro(idlibro,titulo,edicion,fecha,isbn,paginas,
							codigo,condicion,estado,comentario,autor.get(),
							categoria.get(),editorial.get());
					
					libroModel.save(libro);
					
					resultado = "Libro Actualizado";
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
				Optional<Libro> optlibro = libroModel.findById(id);
				if(optlibro.isPresent()) {
					Libro libro = optlibro.get();
					
					libroModel.delete(libro);
					resultado = "Libro Eliminada";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				resultado = "Error";
			}
			
			return resultado;
		}

	}

