package it.ats.controllo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                            throws ServletException, IOException {  
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
         
       
        //recupero sessione 
        HttpSession session=request.getSession();  
        //invalido sessione
        session.invalidate();  
          
        out.print("You are successfully logged out!");  
          
        out.close();  
        
        request.getRequestDispatcher("index.html").forward(request, response);  
}  
}  
