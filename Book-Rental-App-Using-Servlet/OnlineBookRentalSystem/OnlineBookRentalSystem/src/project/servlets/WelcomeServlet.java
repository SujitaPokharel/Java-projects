package project.servlets;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

//Starting URL:  http://localhost:8080/OnlineBookRentalSystem
//See web.xml file for servlet mappings
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/WelcomePage.jsp");
		dispatch.forward(request, response);
	}

}
