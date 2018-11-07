package it.ats.controllo.filtri.validazioneform;

import java.io.IOException;
import java.util.Collection;
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
import it.ats.persistenza.impl.DAOVisitatoreImpl;
import oracle.net.nt.SdpNTAdapter;

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

		if (nome.length() > 20 || nome.contains("\\d+")) {
			map.put("nome", "Il nome deve essere di max 20 caratteri.Non pu� contenere numeri");
		}

		String cognome = request.getParameter("cognome");
		if (cognome.length() > 20 || cognome.contains("\\d+")) {
			map.put("cognome", "Il cognome deve essere di max 20 caratteri.Non pu� contenere numeri");
		}
		String codf = request.getParameter("codf");
		if (codf.length() != 16) {
			map.put("codf", "Codice fiscale non valido");
		}
		String email = request.getParameter("email");
		if (!email.contains("@") || email.length() > 40) {
			map.put("email", "Email non valida");
		}

		String dataNascita = request.getParameter("dataNascita");
		System.out.println(dataNascita);

		String username = request.getParameter("username");
		DAOUtenteRegistratoImpl daoUtenteRegistratoImpl = new DAOUtenteRegistratoImpl();
		try {
			String findUsername = daoUtenteRegistratoImpl.findUsername(username);
			if (findUsername != null) {

				map.put("username", "Username gi� esistente");
			}

		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

		if (!map.isEmpty()) {
			request.setAttribute("mappaErrori", map);
			request.getRequestDispatcher("../guest/registrazione.jsp").forward(request, response);
			
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
