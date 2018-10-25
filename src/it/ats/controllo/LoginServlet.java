package it.ats.controllo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOUtenteRegistrato;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

/**
 * Servlet implementation class LoginServlet
 */


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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOUtenteRegistrato daoUtenteRegistrato = new DAOUtenteRegistratoImpl();

		UtenteRegistrato utenteRegistrato = null;

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {

			utenteRegistrato = daoUtenteRegistrato.verificaAccount(username, password);
		} catch (DAOException e) {

			System.out.println(e.getMessage());

		}

		if(utenteRegistrato==null)
			response.sendRedirect("errorpage.jsp");
		else {
			request.getSession().setAttribute("id", utenteRegistrato.getID());
			request.getSession().setAttribute("ruolo", utenteRegistrato.getFlag_ruolo());
					
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("profilo.jsp");
		rd.forward(request, response);

	}

}