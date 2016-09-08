package es.uc3m.tiw.lab3.ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SaludosBean
 * @author David Palomar
 */
@Stateless(name="ServicioSaludos")
@LocalBean
public class SaludosBean implements SaludosBeanLocal {

    /**
     * Default constructor. 
     */
    public SaludosBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public String saludar(String nombre){
    	return String.format("Hola %s", nombre);
    }

}
