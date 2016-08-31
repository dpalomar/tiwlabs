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
public class DireccionDAOImpl implements DireccionDAO {

	
	private EntityManager em;
	private UserTransaction ut;

	/* (non-Javadoc)
	 * @see es.uc3m.tiw.lab2.daos.DireccionDAO#actualizarDireccion(es.uc3m.tiw.lab2.dominios.Direccion)
	 */
	@Override
	public Direccion actualizarDireccion(Direccion direccion)
			throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException, NotSupportedException {
		ut.begin();
		Direccion d = em.merge(direccion);
		ut.commit();
		
		return d;
		
	}

	/* (non-Javadoc)
	 * @see es.uc3m.tiw.lab2.daos.DireccionDAO#borrarDireccion(es.uc3m.tiw.lab2.dominios.Direccion)
	 */
	@Override
	public void borrarDireccion(Direccion direccion)
			throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException, NotSupportedException {
		ut.begin();
		em.remove(em.merge(direccion));
		ut.commit();
	}

	/* (non-Javadoc)
	 * @see es.uc3m.tiw.lab2.daos.DireccionDAO#crearDireccion(es.uc3m.tiw.lab2.dominios.Direccion)
	 */
	@Override
	public Direccion crearDireccion(Direccion direccion)
			throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException, NotSupportedException {
			ut.begin();
			em.persist(direccion);
			ut.commit();
		return findByPKClave(direccion.getId());
		
	}

	/* (non-Javadoc)
	 * @see es.uc3m.tiw.lab2.daos.DireccionDAO#findByPKClave(int)
	 */
	@Override
	public Direccion findByPKClave(int pk) throws SQLException {
		return em.find(Direccion.class, pk);
	}

	/* (non-Javadoc)
	 * @see es.uc3m.tiw.lab2.daos.DireccionDAO#listarDirecciones()
	 */
	@Override
	public Collection<Direccion> listarDirecciones() throws SQLException {
		
		return em.createQuery("select d from Direccion d").getResultList();
	}

	/* (non-Javadoc)
	 * @see es.uc3m.tiw.lab2.daos.DireccionDAO#setConexion(javax.persistence.EntityManager)
	 */
	@Override
	public void setConexion(EntityManager em) {
			this.em = em;
	}

	/* (non-Javadoc)
	 * @see es.uc3m.tiw.lab2.daos.DireccionDAO#setTransaction(javax.transaction.UserTransaction)
	 */
	@Override
	public void setTransaction(UserTransaction ut) {

		this.ut = ut;
		
	}

}
