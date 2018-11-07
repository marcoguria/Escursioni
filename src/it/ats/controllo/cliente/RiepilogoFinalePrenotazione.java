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
import it.ats.persistenza.impl.DAOPrenotazioneImpl;

/**
 * Servlet implementation class RiepilogoFinalePrenotazione
 */
@WebServlet("/cliente/RiepilogoFinalePrenotazione")
public class RiepilogoFinalePrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RiepilogoFinalePrenotazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOCartaPagamentoImpl cartaPagamentoImpl = new DAOCartaPagamentoImpl();
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Long idEscursione = Long.parseLong(request.getParameter("idEscursione"));
		Long idCarta = Long.parseLong(request.getParameter("idCarta"));
		Escursione escursione = new Escursione();
		CartaPagamento cartaPagamento = new CartaPagamento();

		try {
			escursione = daoEscursioneImpl.findById(idEscursione);
			cartaPagamento = cartaPagamentoImpl.findCartePagamentoByIdCarta(idCarta);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

		request.setAttribute("escursione", escursione);
		request.setAttribute("carta", cartaPagamento);
		RequestDispatcher rd = request.getRequestDispatcher("riepilogoFinalePrenotazione.jsp");
		rd.forward(request, response);
	}

}
