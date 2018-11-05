package it.ats.controllo;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOEscursioneImpl;

/**
 * Servlet implementation class AbilitaEscursioneServlet
 */
@WebServlet("/AbilitaEscursioneServlet")
public class AbilitaEscursioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbilitaEscursioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		DAOEscursioneImpl daoEscursioneImpl= new DAOEscursioneImpl();
		Collection<Escursione> allEscursioni = null;

		try {
			long escursioneBlock = Long.parseLong(request.getParameter("idEscursione"));
		
			

					daoEscursioneImpl.sbloccaEscursione(escursioneBlock);
					
						

		} catch (NumberFormatException | DAOException e) {
			System.out.println(e.getMessage());
		}
	
		request.getRequestDispatcher("gestisciEscursioni.jsp").forward(request, response);
	}

}
