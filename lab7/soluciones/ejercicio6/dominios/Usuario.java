package es.uc3m.tiw.dominios;

import java.util.Set;

public class Usuario {

	private String nombre;
	private int edad;
	private Set<Direccion> direccion;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param edad
	 * @param direccion
	 */
	public Usuario(String nombre, int edad, Set<Direccion> direccion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the direccion
	 */
	public Set<Direccion> getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(Set<Direccion> direccion) {
		this.direccion = direccion;
	}
	
}
