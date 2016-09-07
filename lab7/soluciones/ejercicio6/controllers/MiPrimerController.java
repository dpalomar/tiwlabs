package es.uc3m.tiw.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.uc3m.tiw.dominios.Direccion;
import es.uc3m.tiw.dominios.Usuario;

@Controller
public class MiPrimerController {

	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		Set<Direccion> direcciones = new HashSet<>();
		direcciones.add(new Direccion("calle uno", 1111));
		direcciones.add(new Direccion("calle dos", 2222));
		
		usuario = new Usuario("usuario1", 11, direcciones);
	}
	
	@RequestMapping("/saludos/{nombre}")
	public String saludos(Model modelo, @PathVariable String nombre){
		modelo.addAttribute("name", nombre);
		return "hola";
	}
	
	@RequestMapping("/params/{nombre}/{edad}")
	public @ResponseBody String parametros(@PathVariable String nombre, @PathVariable int edad){
		return "Los parámetros son: "+nombre+" y "+edad;
	}
	
	@RequestMapping("/usuario")
	public @ResponseBody Usuario holaUsuario(){
		return usuario;
	}
	
}
