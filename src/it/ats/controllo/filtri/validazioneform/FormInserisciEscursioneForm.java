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
 * Servlet Filter implementation class FormInserisciEscursioneForm
 */
@WebFilter("/validazioneform/FormInserisciEscursioneForm")
public class FormInserisciEscursioneForm implements Filter {

	/**
	 * Default constructor.
	 */
	public FormInserisciEscursioneForm() {
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

		String luogo = request.getParameter("luogo");

		if (luogo.length() > 30) {
			map.put("luogo", "Nome troppo lungo");
		}

		String tipo = request.getParameter("tipo");
		
		if (!(tipo.equals("mare") || tipo.equals("montagna") || tipo.equals("lago"))) {
			map.put("tipo", "Tipo non corretto. Valori accettati: mare - montagna - lago");
		}

			

		String difficolta = request.getParameter("difficolta");
		if (!(difficolta.equals("bassa") || difficolta.equals("media") || difficolta.equals("alta"))) {
			map.put("difficolta", "Inserire bassa  media o alta");
		}

		
		String guida = request.getParameter("guida");
		if (guida.matches(".*\\d+.*")) {
			map.put("guida", "Guida non può contenere numeri");
		}

		
		if (!map.isEmpty()) {
			request.setAttribute("mappaErrori", map);
			request.getRequestDispatcher("../admin/inserisciEscursione.jsp").forward(request, response);

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
