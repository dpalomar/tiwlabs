package es.uc3m.tiw.dominios;

public class Direccion {

	private String calle;
	private int cod_postal;
	public Direccion() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param calle
	 * @param cod_postal
	 */
	public Direccion(String calle, int cod_postal) {
		super();
		this.calle = calle;
		this.cod_postal = cod_postal;
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
	 * @return the cod_postal
	 */
	public int getCod_postal() {
		return cod_postal;
	}
	/**
	 * @param cod_postal the cod_postal to set
	 */
	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}
}
