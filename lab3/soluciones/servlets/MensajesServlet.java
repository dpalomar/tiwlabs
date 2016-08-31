package es.uc3m.tiw.lab3.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.lab1.dominios.Usuario;
import es.uc3m.tiw.lab2.daos.UsuarioDAO;
import es.uc3m.tiw.lab2.daos.UsuarioDAOImpl;
import es.uc3m.tiw.lab3.daos.MensajesDAO;
import es.uc3m.tiw.lab3.daos.MensajesDAOImpl;
import es.uc3m.tiw.lab3.dominios.Mensaje;
import es.uc3m.tiw.lab3.util.EscribeEnCola;

/**
 * Servlet implementation class MensajesServlet
 */
@WebServlet("/mensajes")
public class MensajesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="demo-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	private UsuarioDAO dao;
	private MensajesDAO msgDao;
	@Inject
	private EscribeEnCola colaMensajes;
       

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		dao = new UsuarioDAOImpl(em, ut);
		msgDao = new MensajesDAOImpl(em, ut);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession sesion = request.getSession();
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		List<Mensaje> mensajes = msgDao.findAllMessagesByUsuario(u);
		request.setAttribute("listaMensajes", mensajes);
		this.getServletContext().getRequestDispatcher("/listaMensajes.jsp").forward(request, response);
		
		
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Mensaje msg = null;
		try {
			String mensaje = request.getParameter("mensaje");
			Usuario from = dao.recuperarUnUsuarioPorClave(Integer.valueOf(request.getParameter("from")));
			Usuario to = dao.recuperarUnUsuarioPorClave(Integer.valueOf(request.getParameter("to")));
			msg = new Mensaje(mensaje,from, to);
			
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		colaMensajes.enviar(msg);
		
		this.getServletConfig().getServletContext().getRequestDispatcher("/login").forward(request, response);
		
		
		
	
	}

}
