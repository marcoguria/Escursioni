package it.ats.controllo.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.CartaPagamento;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOCartaPagamentoImpl;

/**
 * Servlet implementation class EliminaCartaServlet
 */
@WebServlet("/EliminaCartaServlet")
public class EliminaCartaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminaCartaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		
		DAOCartaPagamentoImpl daoCartaPagamentoImpl = new DAOCartaPagamentoImpl();
		
		try {
			
			System.out.println("il numero della carta is: " + request.getParameter("numero_carta"));
			daoCartaPagamentoImpl.eliminaCartaPagamento(daoCartaPagamentoImpl
					.findCartePagamentoByNumeroCarta(Long.parseLong(request.getParameter("numero_carta"))));
		} catch (NumberFormatException | DAOException e) {
			System.out.println(e.getMessage());
			
			
		}
		
		 request.getRequestDispatcher("profilo.jsp").forward(request, response);  

	}

}
