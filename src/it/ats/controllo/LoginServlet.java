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
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOUtenteRegistrato;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

/**
 * Servlet implementation class LoginServlet
 */


//request.getSession().setAttribute("id",utente.getId());
//request.getSession().setAttribute("ruolo", utente.getRuolo());




@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOUtenteRegistratoImpl daoUtenteRegistratoImpl = new DAOUtenteRegistratoImpl();
		
		//DAOUtenteRegistratoImpl daoUtenteRegistratoImpl= null;	
 
		//daoUtenteRegistratoImpl = daoUtenteRegistratoImpl.verificaAccount(username, password);
			
	
		
		
		//request.setAttribute("escursioni", escursioni);
		RequestDispatcher rd = request.getRequestDispatcher("escursioni.jsp");
		rd.forward(request, response);
		
		
		
	}

}
