package it.ats.controllo;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOAmministratore;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOAmministratoreImpl;

/**
 * Servlet implementation class BloccaUtenteServlet
 */
@WebServlet("/BloccaUtenteServlet")
public class BloccaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BloccaUtenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOAmministratoreImpl daoAmministratoreImpl = new DAOAmministratoreImpl();
		Collection<UtenteRegistrato> allUtenti = null;

		try {
			long utenteBlock = Long.parseLong(request.getParameter("idCliente"));

			System.out.println("id utente da bloccare:" + utenteBlock);
			UtenteRegistrato utenteRegistrato = daoAmministratoreImpl
					.findUtenteByID(Long.parseLong(request.getParameter("idCliente")));

			System.out.println(utenteRegistrato.getNome());

			daoAmministratoreImpl.bloccaUtente(utenteRegistrato);
			allUtenti = daoAmministratoreImpl.findAllUtenti();

		} catch (NumberFormatException | DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("utenti", allUtenti);
		request.getRequestDispatcher("gestisciClienti.jsp").forward(request, response);

	}

}
