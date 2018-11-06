package it.ats.controllo.filtri;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class VerificaPermessiFilter
 */
@WebFilter("/VerificaPermessiFilter")
public class VerificaPermessiFilter implements Filter {

    /**
     * Default constructor. 
     */
    public VerificaPermessiFilter() {
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
	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) request1;
		HttpServletResponse response=(HttpServletResponse) response1;
		
		if ((int) request.getSession().getAttribute("ruolo") == 1 ) {
			
			response.sendRedirect("../");
		}
		else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
