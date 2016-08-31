package es.uc3m.tiw.lab3.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.lab3.ejbs.SaludosBeanLocal;

/**
 * Servlet implementation class SaludosServlet
 * @author David Palomar
 */
@WebServlet("/bienvenida")
public class SaludosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB(name="ServicioSaludos")
    SaludosBeanLocal servicio;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8080/laboratorios/bienvenida?nombre=xxxx
		String nombre = request.getParameter("nombre");
		PrintWriter out = response.getWriter();
		out.println(servicio.saludar(nombre));
		out.close();
	}

}
