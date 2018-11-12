package it.ats.controllo.filtri.permessi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 * Servlet Filter implementation class VerificaPermessiClienteFilter
 */
@WebFilter("/permessi/VerificaPermessiClienteFilter")
public class VerificaPermessiClienteFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public VerificaPermessiClienteFilter() {
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
	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;

		if (request.getSession().getAttribute("ruolo") == null) {

			PrintWriter out = response.getWriter();

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Prima di prenotare devi effettuare il login ');");
			out.println("location='../';");
			out.println("</script>");


		} else if ((int) request.getSession().getAttribute("ruolo") != 1) {
			System.out.println("non sei un cliente\n");
			response.sendRedirect("../");
		} else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
