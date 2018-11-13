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

import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

/**
 * Servlet Filter implementation class FormRegistrazioneFilter
 */
@WebFilter("/validazioneform/FormRegistrazioneFilter")
public class FormRegistrazioneFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public FormRegistrazioneFilter() {
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

		String nome = request.getParameter("nome");

		if (nome.length() > 20 || nome.matches(".*\\d+.*")) {
			map.put("nome", "Il nome deve essere di max 20 caratteri. Non può contenere numeri");
		}

		String cognome = request.getParameter("cognome");
		if (cognome.length() > 20 || cognome.matches(".*\\d+.*")) {
			map.put("cognome", "Il cognome deve essere di max 20 caratteri.Non può contenere numeri");
		}
		String codf = request.getParameter("codf");
		if (codf.length() != 16) {
			map.put("codf", " Codice fiscale deve contenere 16 caratteri");
		}

		String username = request.getParameter("username");
		DAOUtenteRegistratoImpl daoUtenteRegistratoImpl = new DAOUtenteRegistratoImpl();
		
		
		try {
			String findUsername = daoUtenteRegistratoImpl.findUsername(username);

			if (request.getParameter("contesto").equals("registrazione")) {
				if (findUsername != null) {

					map.put("username", "Username già esistente");
				}
			}
			

		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

		String password = request.getParameter("password");

		if (password.length() < 3) {
			map.put("password", "Password troppo corta, min 3 caratteri");
		}

		String conferma = request.getParameter("conferma");

		if (!password.equals(conferma)) {
			map.put("conferma", "password e conferma password non corrispondo");
		}

		if (!map.isEmpty()) {
			request.setAttribute("mappaErrori", map);
			if (request.getParameter("contesto").equals("registrazione")) {
				request.getRequestDispatcher("../guest/registrazione.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("../utenteregistrato/GetMyProfileServlet").forward(request, response);
			}

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
