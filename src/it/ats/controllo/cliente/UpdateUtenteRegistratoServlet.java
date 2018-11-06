package it.ats.controllo.cliente;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.CartaPagamento;
import it.ats.modello.Cliente;
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOGuest;
import it.ats.persistenza.impl.DAOCartaPagamentoImpl;
import it.ats.persistenza.impl.DAOGuestImpl;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

/**
 * Servlet implementation class UpdateUtenteRegistratoServlet
 */
@WebServlet("/UpdateUtenteRegistratoServlet")
public class UpdateUtenteRegistratoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUtenteRegistratoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOCartaPagamentoImpl daoCartaPagamentoImpl = new DAOCartaPagamentoImpl();
		Collection<CartaPagamento> cartePagamenti = null;
		DAOUtenteRegistratoImpl daoUtenteRegistratoImpl = new DAOUtenteRegistratoImpl();

		UtenteRegistrato cliente = new Cliente();
		cliente.setID((Long) request.getSession().getAttribute("id_utente"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCognome(request.getParameter("cognome"));
		cliente.setCodf(request.getParameter("codf"));
		cliente.setEmail(request.getParameter("email"));
		String string = request.getParameter("dataNascita");
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(string);
			System.out.println(date1);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cliente.setData_nascita(date1);
		cliente.setFlag_ruolo(1);
		cliente.setUsername(request.getParameter("username"));
		cliente.setPassword(request.getParameter("password"));

		try {
			daoUtenteRegistratoImpl.updateUtente(cliente);
			cartePagamenti = daoCartaPagamentoImpl.findCartePagamentoByIdUtente(cliente.getID());

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("utente", cliente);
		request.setAttribute("cartePagamenti", cartePagamenti);
		request.getRequestDispatcher("profilo.jsp").forward(request, response);
	}

}
