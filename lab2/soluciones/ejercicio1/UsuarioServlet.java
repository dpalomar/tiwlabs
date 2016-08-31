package es.uc3m.tiw.lab2.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private UsuarioDAO dao;
	private Connection con;
	private static final String ALTA="ALTA",EDITAR="EDITAR",BORRAR="BORRAR";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		String configuracion = (String)config.getServletContext().getInitParameter("configuracion");
		ResourceBundle rb = ResourceBundle.getBundle(configuracion);
		Conector conector = Conector.getInstance();
		//con = conector.crearConexionMySQL(rb);
		Connection con = conector.crearConexionMySQLConJNDI(rb);
		dao = new UsuarioDAOImpl();
		dao.setConexion(con);
		dao.setQuerys(rb);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");

			String pagina = null;
		
			if (accion.equals(ALTA)) {
				pagina = "/altausuario.jsp";
				
			}else if (accion.equals(EDITAR)) {
				Usuario usuario = recuperarDatosUsuario(request);
				request.setAttribute("usuario", usuario);
				pagina = "/editarusuario.jsp";
				
			}else if (accion.equals(BORRAR)) {
				Usuario usuario = recuperarDatosUsuario(request);
				pagina = "/login.jsp";
				borrarUsuario(usuario);
			}
			config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}

	/**
	 * Obtiene los datos del usuario a editar o borrar
	 * @param request
	 * @return
	 */
	private Usuario recuperarDatosUsuario(HttpServletRequest request) {
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPassword(request.getParameter("password"));
		return usuario;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		String pagina = "/login.jsp";
		if ((sesion.getAttribute("autenticado").toString()).equalsIgnoreCase("true")) {
			
			pagina = "/formulario?nombre=root&clave=admin";
		
		if (accion.equalsIgnoreCase(ALTA)) {
			Usuario usuario = new Usuario();
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setPassword(request.getParameter("password"));
			altaUsuario(usuario);
		}else if (accion.equalsIgnoreCase(EDITAR)) {
			Usuario usuario = recuperarDatosUsuario(request);
			modificarUsuario(usuario);
		 }
		}
		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}
	/**
	 * Modifica los datos del usuario con el UsuarioDao
	 * @param usuario
	 */
	private void modificarUsuario(Usuario usuario){
		try {
			dao.actualizarUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Borra los datos de un usuario con el UsuarioDao
	 * @param usuario
	 */
	private void borrarUsuario(Usuario usuario){
		try {
			dao.borrarUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Crea un usuario en la base de datos con el UsuarioDao
	 * @param usuario
	 */
	private void altaUsuario(Usuario usuario){
		try {
			dao.crearUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
