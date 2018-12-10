package com.lep4.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormularioController {


		@RequestMapping(value="/form", method=RequestMethod.GET)
		public String formulario(Model model) {
			model.addAttribute("formulario", new Formulario());
			return "form.html";
		}
		
		//Para capturar datos
		@PostMapping("/form")
		public String capturarF(@ModelAttribute Formulario formulario) {
			
			System.out.println("\nEnviando datos... ");	
			System.out.print(formulario);
			return "resultado.html";
		}

}
