package it.ats.controllo.cliente;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.Escursione;
import it.ats.modello.Prenotazione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOEscursioneImpl;
import it.ats.persistenza.impl.DAOPrenotazioneImpl;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

/**
 * Servlet implementation class ConfermaPrenotazioneServlet
 */
@WebServlet("/ConfermaPrenotazioneServlet")
public class ConfermaPrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfermaPrenotazioneServlet() {
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
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		DAOUtenteRegistratoImpl daoUtenteRegistratoImpl = new DAOUtenteRegistratoImpl();
		Prenotazione prenotazione = new Prenotazione();

		try {
		
			Escursione escursione=null;
			
			escursione =daoEscursioneImpl.findById(Long.parseLong(request.getParameter("idEscursione")));//ottengo l escursione
			
			escursione.setNumPrenotati(escursione.getNumPrenotati() + 1);
			
			//incrementare il numero di partecipanti e aggiornare il database
			daoEscursioneImpl.updateEscursione(escursione);
			
			//ottenere nuovamente quella escursione aggiornata  e assegnarla
			
			prenotazione.setEscursione(daoEscursioneImpl.findById(Long.parseLong(request.getParameter("idEscursione"))));
			prenotazione.setData_prenotazione(new Date());
		
			Long id_utente = (Long) (request.getSession().getAttribute("id_utente"));
			prenotazione.setUtenteRegistrato(daoUtenteRegistratoImpl.findUtenteById(id_utente));
			
			/*Aggiungo la prenotazione nel database*/
			daoPrenotazioneImpl.addPrenotazione(prenotazione);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		request.getRequestDispatcher("profilo.jsp").forward(request, response);
	}

}
