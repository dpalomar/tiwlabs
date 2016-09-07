package es.uc3m.tiw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MiPrimerController {

	@RequestMapping("/saludos")
	public @ResponseBody String saludos(){
		return "Hola";
	}
	
	@RequestMapping("/params/{nombre}/{edad}")
	public @ResponseBody String parametros(@PathVariable String nombre, @PathVariable int edad){
		return "Los parámetros son: "+nombre+" y "+edad;
	}
}
