package project.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.domain.Books;
import project.services.BookService;

public class TransactionCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rentalTime = request.getParameter("rentalTime");
		request.setAttribute("rentalTime", rentalTime);
		ArrayList<Books> bookList = (ArrayList<Books>) request.getSession().getAttribute("bookCart");
		BookService bookService = new BookService();

		try {
			for (Books book : bookList)
				bookService.updateBookCheckedOut(book.getBookId());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/TransactionComplete.jsp");
		dispatch.forward(request, response);
	}
}
