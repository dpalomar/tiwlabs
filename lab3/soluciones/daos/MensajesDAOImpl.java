/**
 * 
 */
package es.uc3m.tiw.lab3.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.resource.NotSupportedException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.lab1.dominios.Usuario;
import es.uc3m.tiw.lab3.dominios.Mensaje;

/**
 * @author David Palomar
 *
 */
public class MensajesDAOImpl implements MensajesDAO {
	private EntityManager em;
	private UserTransaction ut;
	
	public MensajesDAOImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	public MensajesDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.lab3.daos.MensajesDAO#findAllMessagesByUsuario(es.uc3m.tiw.lab1.dominios.Usuario)
	 */
	@Override
	public List<Mensaje> findAllMessagesByUsuario(Usuario usuario){
		Usuario u = em.find(Usuario.class, usuario.getId());
		return em.createQuery("select m from Mensaje m where m.to=:to", Mensaje.class)
				.setParameter("to", usuario)
				.getResultList();

	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.lab3.daos.MensajesDAO#createMensaje(es.uc3m.tiw.lab3.dominios.Mensaje)
	 */
	@Override
	public void createMensaje(Mensaje mensaje) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException, javax.transaction.NotSupportedException, javax.transaction.RollbackException {
		ut.begin();
		em.persist(mensaje);
		ut.commit();
		
	}
}
