package it.ats.controllo;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.Escursione;
import it.ats.modello.Prenotazione;
import it.ats.persistenza.DAOEscursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOEscursioneImpl;
import it.ats.persistenza.impl.DAOPrenotazioneImpl;

/**
 * Servlet implementation class VisualizzaMiePrenotazioniServlet
 */
@WebServlet("/VisualizzaMiePrenotazioniServlet")
public class VisualizzaMiePrenotazioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaMiePrenotazioniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOPrenotazioneImpl daoPrenotazioneImpl = new DAOPrenotazioneImpl();
		Collection<Prenotazione> prenotazioni = null;
		
		try {
			
			prenotazioni = daoPrenotazioneImpl.findPrenotazioneByIdUtente((Long) request.getSession().getAttribute("id_utente"));
		} catch (DAOException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		request.setAttribute("prenotazioni", prenotazioni);
		RequestDispatcher rd = request.getRequestDispatcher("visualizzaMiePrenotazioni.jsp");
		rd.forward(request, response);
		

	}

	

}
