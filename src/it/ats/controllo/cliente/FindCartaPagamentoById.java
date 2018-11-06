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
 * Servlet implementation class FindCartaPagamentoById
 */
@WebServlet("/FindCartaPagamentoById")
public class FindCartaPagamentoById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCartaPagamentoById() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOCartaPagamentoImpl cartaPagamentoImpl = new DAOCartaPagamentoImpl();
		
		try {
			CartaPagamento carta = cartaPagamentoImpl.findCartePagamentoByIdCarta(Long.parseLong(request.getParameter("carta")));
			cartaPagamentoImpl.eliminaCartaPagamento(carta);
			
		} catch (NumberFormatException | DAOException e) {
			System.out.println(e.getMessage());
			
		}
		
		
	}

}
