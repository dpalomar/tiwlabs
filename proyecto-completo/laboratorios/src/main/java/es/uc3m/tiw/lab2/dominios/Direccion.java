/**
 * 
 */
package es.uc3m.tiw.lab2.dominios;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;

/**
 * @author David Palomar
 *
 */
@Entity
@Table(name="DIRECCIONES")
public class Direccion {
	@Id	
	@GeneratedValue(strategy = AUTO)
	private int id;
	private String calle;
	private String ciudad;
	private int codigoPostal;
	private String pais;
	
	/**
	 * 
	 */
	public Direccion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param calle
	 * @param ciudad
	 * @param codigoPostal
	 * @param pais
	 */
	public Direccion(String calle, String ciudad, int codigoPostal, String pais) {
		super();
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
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
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the codigoPostal
	 */
	public int getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
