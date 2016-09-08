package es.uc3m.tiw.lab1.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Este filtro intercepta cualquier peticion que vaya a la pagina listado.jsp y comprueba que el usuario se haya autenticado con un token en sesion, en caso contrario le devuelve a la pagina de login.jsp
 * @author David Palomar
 *
 */
@WebFilter("/listado.jsp")
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//accedemos a la sesion del servidor usando un casting al objeto HttpServletRequest ya que nos pasan solamente ServletRequest
		HttpSession sesion =  ((HttpServletRequest)request).getSession(); 
		//buscamos el token de autenticacion
		if (sesion.getAttribute("autenticado")!=null && (boolean)sesion.getAttribute("autenticado")) { 
			
			chain.doFilter(request, response); 
		}else{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
