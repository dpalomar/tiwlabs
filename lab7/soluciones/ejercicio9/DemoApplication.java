package es.uc3m.tiw;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import es.uc3m.tiw.dominios.Direccion;
import es.uc3m.tiw.dominios.Usuario;


@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer{

	private Usuario usuario;
	
	@Autowired
	private UsuarioDao dao;
	/**
	 * Usado cuando es un JAR
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/**
	 * Usado cuando es un WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	
		return builder.sources(DemoApplication.class);
	}
	@PostConstruct
	public void init() {
		Set<Direccion> direcciones = new HashSet<>();
		direcciones.add(new Direccion("calle uno", 1111));
		direcciones.add(new Direccion("calle dos", 2222));
		
		usuario = new Usuario("usuario1", 11, direcciones);
		dao.save(usuario);
	}
}
