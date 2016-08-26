package es.uc3m.tiw.lab1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ejercicio4Servlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final String LOGIN_JSP = "/login.jsp";
	private static final String LISTADO_JSP = "/listado.jsp";
	private static final String ERROR_JSP = "/error.jsp";
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private List<String> listausuarios;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		listausuarios = new ArrayList<>();
		listausuarios.add("Juan");
		listausuarios.add("Eva");
		listausuarios.add("Marta");
		listausuarios.add("Oscar");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		boolean autenticado;
		
		if (sesion.getAttribute("autenticado") != null) {
			autenticado = (boolean) sesion.getAttribute("autenticado");
		}
		else{
			autenticado = false;	
		}
		String pagina = LOGIN_JSP;
		if (autenticado) {
			pagina = LISTADO_JSP;
					
		}
		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("clave");

		String pagina = "";

		//TODO hacer más reglas de validación, tamaño mínimo de la clave y del usuario, caracteres no válidos, etc.
				Map<String, String>errores;

				
				if (nombre.equals("")|| password.equals("")) {
					errores = new HashMap<String, String>();
					if (nombre.equals("")) {
						errores.put("nombre", "El nombre no puede quedar en blanco");	
					}
					if (password.equals("")) {
						errores.put("clave", "El campo password no puede estar vacío");
							
					}
					
					request.setAttribute("errores", errores);
					pagina = LOGIN_JSP;
				}
				else if (nombre.equals("usuario1") && password.equals("password1")) {
					sesion.setAttribute("autenticado", true);			
					pagina = LISTADO_JSP;
					request.setAttribute("usuarios", listausuarios);

				} else {
					sesion.setAttribute("autenticado", false);
					pagina = ERROR_JSP;
		
				}

		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}

}
