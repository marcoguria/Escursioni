package it.ats.controllo.guest;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOEscursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOEscursioneImpl;

/**
 * Servlet implementation class FindEscursioniDisponibili
 */
@WebServlet("/guest/FindEscursioniDisponibiliServlet")
public class FindEscursioniDisponibiliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindEscursioniDisponibiliServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEscursione daoEscursione = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = null;
		
		try {
			
			escursioni = daoEscursione.findEscursioniDisponibili();
		} catch (DAOException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		request.setAttribute("escursioni", escursioni);
		RequestDispatcher rd = request.getRequestDispatcher("escursioni.jsp");
		rd.forward(request, response);
		

	}

}
