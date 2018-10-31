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
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOEscursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOUtenteRegistrato;
import it.ats.persistenza.impl.DAOEscursioneImpl;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

/**
 * Servlet implementation class MostraClientiServlet
 */
@WebServlet("/MostraUtentiRegistratiServlet")
public class MostraUtentiRegistratiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraUtentiRegistratiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOUtenteRegistrato daoUtenteRegistrato = new DAOUtenteRegistratoImpl();
		Collection<UtenteRegistrato> utenti = null;
		
		try {
			
			utenti = daoUtenteRegistrato.findAll();
		} catch (DAOException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		request.setAttribute("utenti", utenti);
		RequestDispatcher rd = request.getRequestDispatcher("utenti.jsp");
		rd.forward(request, response);
		

	}

}
