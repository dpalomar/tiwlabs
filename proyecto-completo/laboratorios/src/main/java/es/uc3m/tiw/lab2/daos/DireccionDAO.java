/**
 * 
 */
package es.uc3m.tiw.lab2.daos;

import java.sql.SQLException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.lab2.dominios.Direccion;

/**
 * @author David Palomar
 *
 */
public interface DireccionDAO {
	
	public abstract Direccion actualizarDireccion(Direccion direccion) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract void borrarDireccion(Direccion direccion) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract Direccion crearDireccion(Direccion direccion) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;

	public abstract Direccion findByPKClave(int pk) throws SQLException;

	public abstract Collection<Direccion> listarDirecciones() throws SQLException;

	public abstract void setConexion(EntityManager em);

	void setTransaction(UserTransaction ut);

}
