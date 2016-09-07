package es.uc3m.tiw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MiPrimerController {

	@RequestMapping("/saludos/{nombre}")
	public String saludos(Model modelo, @PathVariable String nombre){
		modelo.addAttribute("name", nombre);
		return "hola";
	}
	
	@RequestMapping("/params/{nombre}/{edad}")
	public @ResponseBody String parametros(@PathVariable String nombre, @PathVariable int edad){
		return "Los parámetros son: "+nombre+" y "+edad;
	}
}
