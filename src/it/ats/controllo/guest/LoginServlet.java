package it.ats.controllo.guest;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/guest/LoginServlet")
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

		if (utenteRegistrato == null) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Account non valido');");
			out.println("location='login.jsp';");
			out.println("</script>");

		} else {
			request.getSession().setAttribute("id_utente", utenteRegistrato.getID());
			request.getSession().setAttribute("ruolo", utenteRegistrato.getFlag_ruolo());
			response.sendRedirect("../utenteregistrato/home.jsp");

		}

	}

}
