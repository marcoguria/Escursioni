package it.ats.controllo.utenteregistrato;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.CartaPagamento;
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOCartaPagamentoImpl;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

/**
 * Servlet implementation class GetMyProfileServlet
 */
@WebServlet("/utenteregistrato/GetMyProfileServlet")
public class GetMyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMyProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOUtenteRegistratoImpl daoUtenteRegistratoImpl = new DAOUtenteRegistratoImpl();
		DAOCartaPagamentoImpl daoCartaPagamentoImpl = new DAOCartaPagamentoImpl();
		Collection<CartaPagamento> cartePagamenti = null;
		UtenteRegistrato utenteRegistrato = null;

		try {

			utenteRegistrato = daoUtenteRegistratoImpl
					.findUtenteById((Long) request.getSession().getAttribute("id_utente"));
			
			cartePagamenti = daoCartaPagamentoImpl
					.findCartePagamentoByIdUtente((Long) request.getSession().getAttribute("id_utente"));
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

		request.setAttribute("utente", utenteRegistrato);
		request.setAttribute("cartePagamenti", cartePagamenti);
		request.getRequestDispatcher("modificaProfilo.jsp").forward(request, response);
		
	}

}
