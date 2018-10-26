package it.ats.controllo;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.CartaPagamento;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOCartaPagamentoImpl;

/**
 * Servlet implementation class PagamentoServlet
 */
@WebServlet("/PagamentoServlet")
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOCartaPagamentoImpl cartaPagamentoImpl= new DAOCartaPagamentoImpl();
		Collection<CartaPagamento> cartaPagamentos=null;
		
		
		try {
			cartaPagamentos = cartaPagamentoImpl.findCartePagamentoByIdUtente( Long.parseLong( request.getSession().getId()));
			
		} catch (NumberFormatException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("cartePagamento", cartaPagamentos);
		RequestDispatcher rd = request.getRequestDispatcher("scegliPagamento.jsp");
		rd.forward(request, response);
		
	}

}
