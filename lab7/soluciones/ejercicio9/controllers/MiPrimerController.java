package es.uc3m.tiw.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.UsuarioDao;
import es.uc3m.tiw.dominios.Direccion;
import es.uc3m.tiw.dominios.Usuario;

@RestController
public class MiPrimerController {

	private Usuario usuario;
	
	@Autowired
	private UsuarioDao dao;

	
	
	@RequestMapping("/usuario/{nombre}")
	public Usuario holaUsuario(@PathVariable String nombre){
		return dao.findByNombre(nombre);
		
	}
	
	
}
