package es.uc3m.tiw.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.dominios.Direccion;
import es.uc3m.tiw.dominios.Usuario;

@RestController
public class MiPrimerController {

	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		Set<Direccion> direcciones = new HashSet<>();
		direcciones.add(new Direccion("calle uno", 1111));
		direcciones.add(new Direccion("calle dos", 2222));
		
		usuario = new Usuario("usuario1", 11, direcciones);
	}
	
	
	@RequestMapping("/usuario")
	public Usuario holaUsuario(){
		return usuario;
	}
	
}
