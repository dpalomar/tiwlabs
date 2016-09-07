package es.uc3m.tiw.dominios;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private int edad;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="usuarioId")
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

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
}
