package it.ats.controllo.cliente;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.CartaPagamento;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOCartaPagamentoImpl;

/**
 * Servlet implementation class VisualizzaCarteDaEliminareServlet
 */
@WebServlet("/cliente/VisualizzaCarteDaEliminareServlet")
public class VisualizzaCarteDaEliminareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisualizzaCarteDaEliminareServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = (Long) (request.getSession().getAttribute("id_utente"));

		DAOCartaPagamentoImpl cartaPagamentoImpl = new DAOCartaPagamentoImpl();

		Collection<CartaPagamento> cartaPagamentos = null;

		try {
			cartaPagamentos = cartaPagamentoImpl.findCartePagamentoByIdUtente(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			
		}
		
		request.setAttribute("cartePagamenti", cartaPagamentos);
		request.getRequestDispatcher("eliminaCarta.jsp").forward(request, response);
	}

}
