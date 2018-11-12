package it.ats.controllo.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.Prenotazione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOPrenotazioneImpl;

/**
 * Servlet implementation class FindPrenotazioniByIdEscursioneServlet
 */
@WebServlet("/admin/FindPrenotazioniByIdEscursioneServlet")
public class FindPrenotazioniByIdEscursioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPrenotazioniByIdEscursioneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOPrenotazioneImpl daoPrenotazioneImpl = new DAOPrenotazioneImpl();
		Collection<Prenotazione> prenotazioni = new ArrayList<>();
		long idEscursione = Long.parseLong(request.getParameter("idEscursione"));

		try {
			prenotazioni = daoPrenotazioneImpl.findPrenotazioneByIdEscursione(idEscursione);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("prenotazioni", prenotazioni);
		request.getRequestDispatcher("mostraPrenotazioni.jsp").forward(request, response);

	}

}
