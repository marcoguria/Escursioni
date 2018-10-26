package it.ats.controllo;

import java.io.IOException;

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
 * Servlet implementation class FindByIdEscursioneServlet
 */
@WebServlet("/FindByIdEscursioneServlet")
public class FindByIdEscursioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdEscursioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idEscursione = Long.parseLong(request.getParameter("idEscursione"));

		DAOEscursione daoEscursione = new DAOEscursioneImpl();

		Escursione escursione = null;

		try {

			escursione = daoEscursione.findById(idEscursione);
			
			System.out.println(escursione);

		} catch (DAOException e) {

			System.out.println(e.getMessage());

		}
		
		request.setAttribute("escursione", escursione);
		RequestDispatcher rd = request.getRequestDispatcher("mostraEscursione.jsp");
		rd.forward(request, response);
	}
	
	

}
