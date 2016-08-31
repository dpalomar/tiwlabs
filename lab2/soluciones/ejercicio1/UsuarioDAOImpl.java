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

import es.uc3m.tiw.lab1.dominios.Usuario;

/**
 * @author David Palomar
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection con;
	private ResourceBundle rb;
	@Override
	public Collection<Usuario> listarUsuarios() throws SQLException{
		Statement st = con.createStatement();
		ResultSet resultados = st.executeQuery(rb.getString("seleccionarTodosUsuarios"));
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario usuario;
		while (resultados.next()) {
			usuario = new Usuario();
			usuario.setId(resultados.getInt("id"));
			usuario.setNombre(resultados.getString("nombre"));
			usuario.setPassword(resultados.getString("password"));
			listaUsuarios.add(usuario);
		}
		return listaUsuarios;
	}
	@Override
	public Usuario recuperarUnUsuarioPorClave(int pk) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("seleccionarUsuarioPK"));
		ps.setInt(1, pk);
		Usuario usuario = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			usuario = new Usuario();
			usuario.setId(resultados.getInt("id"));
			usuario.setNombre(resultados.getString("nombre"));
			usuario.setPassword(resultados.getString("password"));
			
		}
		return usuario;
	}
	@Override
	/**
	 * Se asume que el campo nombre es unique y por tanto solo recuperará un usuario en caso de existir
	 */
	public Usuario recuperarUnUsuarioPorNombre(String nombre) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("seleccionarUsuarioNombre"));
		ps.setString(1, nombre);
		Usuario usuario = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			usuario = new Usuario();
			usuario.setId(resultados.getInt("id"));
			usuario.setNombre(resultados.getString("nombre"));
			usuario.setPassword(resultados.getString("password"));
			
		}
		return usuario;
	}
	@Override
	public Usuario crearUsuario(Usuario nuevoUsuario) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("crearUsuario"));
		ps.setString(1, nuevoUsuario.getNombre());
		ps.setString(2, nuevoUsuario.getPassword());
		ps.execute();
		
		return recuperarUnUsuarioPorNombre(nuevoUsuario.getNombre());
	}
	@Override
	public void borrarUsuario(Usuario usuario) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("borrarUsuario"));
		ps.setInt(1, usuario.getId());
		ps.execute();
		
	}
	@Override
	public Usuario actualizarUsuario(Usuario usuario) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("actualizarUsuario"));
		ps.setString(1, usuario.getNombre());
		ps.setString(2, usuario.getPassword());
		ps.setInt(3, usuario.getId());
		ps.execute();
		return recuperarUnUsuarioPorClave(usuario.getId());
		
	}
	@Override
	public void setConexion(Connection con) {
		this.con = con;
		
	}
	@Override
	public void setQuerys(ResourceBundle rb) {
		this.rb = rb;
		
	}

}
