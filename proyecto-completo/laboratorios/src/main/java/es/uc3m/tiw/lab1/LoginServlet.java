package es.uc3m.tiw.lab1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

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
	private List<Usuario> usuarios;
	private UsuarioDAO dao;   
	@PersistenceContext(unitName="laboratoriosPU")
	private EntityManager em;
	@Resource
	UserTransaction ut;
		
				@Override
				public void init(ServletConfig config) throws ServletException {
					this.config = config;
					// creamos unos usuarios de prueba al inicio para que no falle dao.listarUsuarios();
					Usuario u1 = new Usuario("Juan", "Sanz", "jsanz", "123456");
					Usuario u2 = new Usuario("Ana", "Alba", "aalba", "123456");
					Usuario u3 = new Usuario("Benito", "Bueno", "bbueno", "123456");
					Usuario u4 = new Usuario("Carlos", "Colmenar", "ccolme", "123456");
					try {
						ut.begin();
						em.persist(u1);
						em.persist(u2);
						em.persist(u3);
						em.persist(u4);
						

						ut.commit();

					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SystemException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RollbackException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (HeuristicMixedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (HeuristicRollbackException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					dao = new UsuarioDAOImpl(); 
					dao.setConexion(em);
					dao.setTransaction(ut);
					
			
		}
	       


		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			config.getServletContext().getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String user = request.getParameter("nombre");
			String password = request.getParameter("clave");
			String mensaje ="";
			String pagina = "";
			pagina = LOGIN_JSP;
			HttpSession sesion = request.getSession();
			
			try {
				usuarios = (List<Usuario>) dao.listarUsuarios();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
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
			
				config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
				
			
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
