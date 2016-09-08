
package es.uc3m.tiw.lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author David Palomar
 *
 */
public class Conector {
private static Conector conector = new Conector();
	
	private  Conector() {

	}
	public static Conector getInstance(){
		if (conector == null) {
			conector = new Conector();
		}
		return conector;
	}

	public Connection crearConexionMySQL(ResourceBundle propiedades){
		
		String bbdd = propiedades.getString("bbdd");
		String driver = propiedades.getString("driver");
		String usuario = propiedades.getString("usuario");
		String clave = propiedades.getString("clave");
		String esquema = propiedades.getString("esquema");
		
		Connection con = null;
		try {
			Class.forName(driver);
			StringBuilder sb = new StringBuilder();
			sb.append(bbdd);
			sb.append("/");
			sb.append(esquema);
			con = DriverManager.getConnection(sb.toString(),usuario,clave);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	public Connection crearConexionMySQLConJNDI(ResourceBundle propiedades){
		DataSource datasource = null;
		Connection con=null;
		try {
			Context ctx = new InitialContext();
			datasource = (DataSource) ctx.lookup(propiedades.getString("datasource"));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public Connection crearConexionOracle(ResourceBundle propiedades){
		return null;
	}
	public Connection crearConexionMSSQL(ResourceBundle propiedades){
		return null;
	}
}
