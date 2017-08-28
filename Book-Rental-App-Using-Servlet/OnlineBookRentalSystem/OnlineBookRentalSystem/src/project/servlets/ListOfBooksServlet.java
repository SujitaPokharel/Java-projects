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

public class ListOfBooksServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Books> bookList = null;
		try {
			BookService bookService = new BookService();
			bookList = bookService.getBookList();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("bookList", bookList);

		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/BookList.jsp");
		dispatch.forward(request, response);
	}

}
