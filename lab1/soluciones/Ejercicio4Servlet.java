package es.uc3m.tiw.lab1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio4Servlet
 */
@WebServlet("/login")
public class Ejercicio4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio4Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Formulario</h1>");
		out.println("<form action='login' method='post'>");
		out.println("<input type='text' name='nombre'>");
		out.println("<br>");
		out.println("<input type='password' name='clave'> ");
		out.println("<input type='submit' value='Enviar'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("clave");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (nombre.equals("usuario1") || password.equals("password1")) {

			out.println("<html>");
			out.println("<body>");
			out.println("<p> Estos son tus datos: " + nombre + " y clave: " + password + "</p>");
			out.println("</body>");
			out.println("</html>");
			out.close();

		} else {
			out.println("<html>");
			out.println("<body>");
			out.println("<p> Usuario incorrecto</p>");
			out.println("<p> <a href='login'>Volver</a></p>");
			out.println("</body>");
			out.println("</html>");
			out.close();

		}
	}

}
