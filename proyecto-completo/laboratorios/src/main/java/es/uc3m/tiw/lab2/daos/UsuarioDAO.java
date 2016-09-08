/**
 * 
 */
package es.uc3m.tiw.lab2.daos;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.lab1.dominios.Usuario;

/**
 * @author David Palomar
 *
 */
public interface UsuarioDAO {
	
	public abstract Usuario actualizarUsuario(Usuario usuario) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract void borrarUsuario(Usuario usuario) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract Usuario crearUsuario(Usuario nuevoUsuario) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract Usuario recuperarUnUsuarioPorNombre(String nombre) throws SQLException;

	public abstract Usuario recuperarUnUsuarioPorClave(int pk) throws SQLException;

	public abstract Collection<Usuario> listarUsuarios() throws SQLException;

	public abstract void setConexion(EntityManager em);

	void setTransaction(UserTransaction ut);

}
