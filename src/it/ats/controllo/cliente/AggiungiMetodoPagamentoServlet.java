package it.ats.controllo.cliente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.CartaPagamento;
import it.ats.modello.Escursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOCartaPagamentoImpl;
import it.ats.persistenza.impl.DAOEscursioneImpl;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

/**
 * Servlet implementation class AggiungiMetodoPagamentoServlet
 */
@WebServlet("/cliente/AggiungiMetodoPagamentoServlet")
public class AggiungiMetodoPagamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AggiungiMetodoPagamentoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CartaPagamento carta = new CartaPagamento();
		DAOUtenteRegistratoImpl daoUtenteRegistratoImpl = new DAOUtenteRegistratoImpl();
		DAOCartaPagamentoImpl daoCartaPagamentoImpl = new DAOCartaPagamentoImpl();
		DAOEscursioneImpl daoEscursione = new DAOEscursioneImpl();
		Escursione escursione = new Escursione();
		Long idEscursione = Long.parseLong(request.getParameter("idEscursione"));
		Long id_utente = (Long) (request.getSession().getAttribute("id_utente"));

		try {

			System.out.println(idEscursione);

			System.out.println("utente: " + id_utente);
			System.out.println("escursione " + idEscursione);

			carta.setTipo(request.getParameter("tipoCarta"));
			long numero_carta = Long.parseLong(request.getParameter("numeroCarta"));
			carta.setNumero_carta(numero_carta);
			carta.setUtente(daoUtenteRegistratoImpl.findUtenteById(id_utente));
			carta.setCvv(Long.parseLong(request.getParameter("cvv")));
			daoCartaPagamentoImpl.aggiungiCartaPagamento(carta);

		} catch (DAOException e1) {
			System.out.println(e1.getMessage());
		}

		request.setAttribute("idEscursione", idEscursione);
		RequestDispatcher rd = request.getRequestDispatcher("FindCarteByIdSessioneServlet");
		rd.forward(request, response);

	}

}
