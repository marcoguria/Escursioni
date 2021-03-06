package it.ats.controllo.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOEscursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOGuest;
import it.ats.persistenza.impl.DAOEscursioneImpl;
import it.ats.persistenza.impl.DAOGuestImpl;

/**
 * Servlet implementation class InserisciEscursioneServlet
 */
@WebServlet("/admin/InserisciEscursioneServlet")
public class InserisciEscursioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InserisciEscursioneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Escursione escursione = new Escursione();

		escursione.setLuogo(request.getParameter("luogo"));
		escursione.setTipo(request.getParameter("tipo"));

		String string = request.getParameter("dataEscursione");
		Date date1 = null;

		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(string);
			System.out.println(date1);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		escursione.setData(date1);

		Double durata = Double.parseDouble(request.getParameter("durata"));
		escursione.setDurata(durata);
		escursione.setDifficolta(request.getParameter("difficolta"));
		Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		escursione.setPrezzo(prezzo);
		escursione.setGuida(request.getParameter("guida"));
		Integer maxPartecipanti = Integer.parseInt(request.getParameter("maxPartecipanti"));
		escursione.setMaxPartecipanti(maxPartecipanti);
		escursione.setDescrizione(request.getParameter("descrizione"));
		

		System.out.println("LA nuova escursione**********:\n\n ");

		DAOEscursione daoEscursione = new DAOEscursioneImpl();

		try {

			System.out.println(escursione);

			daoEscursione.addEscursione(escursione);

		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

		

		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Escursione inserita con successo!');");
		out.println("location='../utenteregistrato/home.jsp';");
		out.println("</script>");
//		response.sendRedirect("../utenteregistrato/home.jsp");
	}

}
