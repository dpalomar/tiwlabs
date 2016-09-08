/**
 * 
 */
package es.uc3m.tiw.lab3.daos;

import java.util.List;

import javax.persistence.RollbackException;
import javax.resource.NotSupportedException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.lab1.dominios.Usuario;
import es.uc3m.tiw.lab3.dominios.Mensaje;

/**
 * @author David Palomar
 *
 */
public interface MensajesDAO {

	List<Mensaje> findAllMessagesByUsuario(Usuario usuario);

	void createMensaje(Mensaje mensaje) throws SecurityException, IllegalStateException, RollbackException,
			HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException, javax.transaction.NotSupportedException, javax.transaction.RollbackException;

}