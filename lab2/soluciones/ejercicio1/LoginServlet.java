package es.uc3m.tiw.lab1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.tiw.lab1.dominios.Usuario;
import es.uc3m.tiw.lab2.Conector;
import es.uc3m.tiw.lab2.daos.UsuarioDAO;
import es.uc3m.tiw.lab2.daos.UsuarioDAOImpl;

	/**
	 * 
	 * 
	 * @author David Palomar
	 */
@WebServlet(
		urlPatterns="/login",
		loadOnStartup=1,
		initParams={@WebInitParam(name="configuracion", value="es.uc3m.tiw.lab2.persistencia")}
		)
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final String LOGIN_JSP = "/login.jsp";
	private static final String LISTADO_JSP = "/listado.jsp";
	private static final String ERROR_JSP = "/error.jsp";
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private Usuario usuario;
	private ArrayList<Usuario> usuarios;
	private UsuarioDAO dao;   

		
				@Override
				public void init(ServletConfig config) throws ServletException {
					this.config = config;
					String configuracion = (String)config.getServletContext().getInitParameter("configuracion");
					ResourceBundle rb = ResourceBundle.getBundle(configuracion);
					Conector conector = Conector.getInstance();
					//Connection con = conector.crearConexionMySQL(rb);
					Connection con = conector.crearConexionMySQLConJNDI(rb);
					dao = new UsuarioDAOImpl();
					dao.setConexion(con);
					dao.setQuerys(rb);
					try {
						usuarios = (ArrayList<Usuario>) dao.listarUsuarios();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		}
	       


		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.getServletContext().getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String user = request.getParameter("usuario");
			String password = request.getParameter("password");
			String mensaje ="";
			String pagina = "";
			pagina = LOGIN_JSP;
			HttpSession sesion = request.getSession();
			Usuario u = comprobarUsuario(user, password);
			if (u != null){
				
				pagina = LISTADO_JSP;
				request.setAttribute("usuarios", usuarios);
				sesion.setAttribute("usuario", u);
				sesion.setAttribute("autenticado", true);
				
			}else{
				
				mensaje = "Usuario o password incorrectos";
				request.setAttribute("mensaje", mensaje);
			}
			
				this.getServletContext().getRequestDispatcher(pagina).forward(request, response);
				
			
		}

		private Usuario  comprobarUsuario(String user, String password) {
			Usuario u = null;
			for (Usuario usuario : usuarios) {
				if (user.equals(usuario.getUsuario()) && password.equals(usuario.getPassword())){
					u = usuario;
					break;
				}
			}
			return u;
		}

}
