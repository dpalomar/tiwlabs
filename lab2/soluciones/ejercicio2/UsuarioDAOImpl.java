/**
 * 
 */
package es.uc3m.tiw.lab2.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
public class UsuarioDAOImpl implements UsuarioDAO {

	private EntityManager em;
	private UserTransaction ut;
	@Override
	public Collection<Usuario> listarUsuarios() throws SQLException{
		
		
		return em.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}
	@Override
	public Usuario recuperarUnUsuarioPorClave(int pk) throws SQLException{
		
		return em.find(Usuario.class, pk);
		
	}
	@Override
	/**
	 * Se asume que el campo usuario es unique y por tanto solo recuperará un usuario en caso de existir
	 */
	public Usuario recuperarUnUsuarioPorNombre(String nombre) throws SQLException{
		
		Query consulta = em.createQuery("select u from Usuario u where u.usuario=:nom", Usuario.class);
		consulta.setParameter("nom", "nombre");
		return (Usuario) consulta.getResultList().get(0);
	}
	@Override
	public Usuario crearUsuario(Usuario nuevoUsuario) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		ut.begin();
		em.persist(nuevoUsuario);
		ut.commit();
		em.flush();
		return recuperarUnUsuarioPorNombre(nuevoUsuario.getUsuario());
	}
	@Override
	public void borrarUsuario(Usuario usuario) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		ut.begin();
		
		em.remove(em.merge(usuario));
		
		ut.commit();
		
	}
	@Override
	public Usuario actualizarUsuario(Usuario usuario) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		//Usuario usuarioActualizado = usuario;
		ut.begin();
		em.merge(usuario);
		ut.commit();
		return recuperarUnUsuarioPorClave(usuario.getId());
		
	}
	@Override
	public void setConexion(EntityManager em) {
		this.em = em;
		
	}
	@Override
	public void setTransaction(UserTransaction ut){
		this.ut = ut;
	}

}
