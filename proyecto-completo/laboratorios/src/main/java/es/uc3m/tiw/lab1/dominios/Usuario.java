/**
 * 
 */
package es.uc3m.tiw.lab1.dominios;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import es.uc3m.tiw.lab2.dominios.Direccion;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;

/**
 * @author David Palomar
 *
 */
@Entity
@Table(name="USUARIOS")
@XmlRootElement
public class Usuario {
	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	@Column(nullable = false, length = 15)
	private String nombre;
	@Column(length = 30)
	private String apellidos;
	@Column(nullable = false, length = 10, unique = true)
	private String usuario;
	@Column(nullable = false)
	private String password;
	
	@OneToOne(cascade = ALL)
	private Direccion direccion;
	private Integer edad;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(String nombre, String apellidos, String usuario,
			String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.password = password;
	}
	public Usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}
	/**
	 * @param edad
	 * @param nombre2
	 */
	public Usuario(Integer edad, String nombre) {
		this.setEdad(edad);
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
}
