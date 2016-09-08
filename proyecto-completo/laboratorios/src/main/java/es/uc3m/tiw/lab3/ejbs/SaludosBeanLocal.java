package es.uc3m.tiw.lab3.ejbs;

import javax.ejb.Local;
/**
 * 
 * @author David Palomar
 *
 */
@Local
public interface SaludosBeanLocal {

	String saludar(String nombre);

}
