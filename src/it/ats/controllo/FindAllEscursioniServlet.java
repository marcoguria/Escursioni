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
import it.ats.persistenza.DAOEscursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOEscursioneImpl;

/**
 * Servlet implementation class FindAllEscursioni
 */
@WebServlet("/FindAllEscursioniServlet")
public class FindAllEscursioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FindAllEscursioniServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEscursione daoEscursione = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = null;
		
		try {
			
			escursioni = daoEscursione.findAll();
		} catch (DAOException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		request.setAttribute("escursioni", escursioni);
		RequestDispatcher rd = request.getRequestDispatcher("escursioni.jsp");
		rd.forward(request, response);
		

	}


}
