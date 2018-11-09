package it.ats.controllo.guest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOEscursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOEscursioneImpl;

/**
 * Servlet implementation class FindEscursioniBySearchServlet
 */
@WebServlet("/guest/FindEscursioniBySearchServlet")
public class FindEscursioniBySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindEscursioniBySearchServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOEscursione daoEscursione = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = null;

		String sql = "select * from ESCURSIONE where ";
		boolean first = true;
		Map<String, String> mapValori = new HashMap<String, String>();

		if (!request.getParameter("tipo").isEmpty()) {

			if (first) {

				sql += "TIPO=?";
				first = false;
				mapValori.put("tipo", request.getParameter("tipo"));
			} else {

				sql += " and TIPO=?";
				mapValori.put("tipo", request.getParameter("tipo"));
			}

		}

		if (!request.getParameter("dataEscursione").isEmpty()) {

			if (first) {

				sql += "DATA_ESCURSIONE=?";
				first = false;

				String string = request.getParameter("dataEscursione");
				Date date1 = null;

				try {
					date1 = new SimpleDateFormat("yyyy-MM-dd").parse(string);
					System.out.println(date1);

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mapValori.put("dataEscursione", date1.toString()); // TODO controllare data escursione
			} else {

				sql += " and DATA_ESCURSIONE=?";
				String string = request.getParameter("dataEscursione");
				Date date1 = null;

				try {
					date1 = new SimpleDateFormat("yyyy-MM-dd").parse(string);
					System.out.println(date1);

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mapValori.put("dataEscursione", date1.toString());
			}
		}

		if (!request.getParameter("luogo").isEmpty()) {

			if (first) {

				sql += "LUOGO=?";
				first = false;
				mapValori.put("luogo", request.getParameter("luogo"));
			} else {

				sql += " and LUOGO=?";
				mapValori.put("luogo", request.getParameter("luogo"));
			}
		}

		if (!request.getParameter("durata").isEmpty()) {

			if (first) {

				sql += "DURATA=?";
				first = false;
				mapValori.put("durata", request.getParameter("durata"));
			} else {

				sql += " and DURATA=?";
				mapValori.put("durata", request.getParameter("durata"));
			}

		}

		if (!request.getParameter("difficolta").isEmpty()) {

			if (first) {

				sql += "DIFFICOLTA=?";
				first = false;
				mapValori.put("difficolta", request.getParameter("difficolta"));
			} else {

				sql += " and DIFFICOLTA=?";
				mapValori.put("difficolta", request.getParameter("difficolta"));
			}
		}
		
		DAOEscursioneImpl daoEscursioneImpl= new DAOEscursioneImpl();
		
		try {
			escursioni = daoEscursioneImpl.findEscursioniBySearch(sql, mapValori);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

		request.setAttribute("escursioni", escursioni);
		RequestDispatcher rd = request.getRequestDispatcher("escursioni.jsp");
		rd.forward(request, response);

	}

}
