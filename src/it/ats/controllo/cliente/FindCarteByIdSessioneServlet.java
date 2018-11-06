package it.ats.controllo.cliente;

import java.io.IOException;
import java.util.Collection;

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

/**
 * Servlet implementation class PagamentoServlet
 */
@WebServlet("/FindCarteByIdSessioneServlet")
public class FindCarteByIdSessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindCarteByIdSessioneServlet() {
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
		Collection<CartaPagamento> cartaPagamentos = null;
		Escursione escursione = new Escursione();

		try {
			Long idEscursione = Long.parseLong(request.getParameter("idEscursione"));
			Long id = (Long)(request.getSession().getAttribute("id_utente"));
			
			cartaPagamentos = cartaPagamentoImpl.findCartePagamentoByIdUtente(id);
			escursione = daoEscursioneImpl.findById(idEscursione);

		} catch (NumberFormatException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("cartePagamento", cartaPagamentos);
		request.setAttribute("escursione", escursione);
		RequestDispatcher rd = request.getRequestDispatcher("scegliPagamento.jsp");
		rd.forward(request, response);

	}

}
