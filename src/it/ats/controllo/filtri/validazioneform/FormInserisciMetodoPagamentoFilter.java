package it.ats.controllo.filtri.validazioneform;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FormInserisciMetodoPagamentoFilter
 */
@WebFilter("/FormInserisciMetodoPagamentoFilter")
public class FormInserisciMetodoPagamentoFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public FormInserisciMetodoPagamentoFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Map<String, String> map = new HashMap<String, String>();

		String tipo = request.getParameter("tipoCarta");
		if (tipo.matches(".*\\d+.*")) {
			map.put("tipoCarta", "Tipo non puo contenere numeri");
		}

		String numeroCarta = request.getParameter("numeroCarta");
		if (numeroCarta.length() != 16) {
			map.put("numeroCarta", "Il numero della carta deve contenere 16 numeri");
		}

		String cvv = request.getParameter("cvv");
		if (cvv.length() != 3) {
			map.put("cvv", "Il cvv deve contenere 3 numeri");
		}

		if (!map.isEmpty()) {
			request.setAttribute("mappaErrori", map);
			request.getRequestDispatcher("../cliente/aggiungiMetodoPagamento.jsp").forward(request, response);

		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
