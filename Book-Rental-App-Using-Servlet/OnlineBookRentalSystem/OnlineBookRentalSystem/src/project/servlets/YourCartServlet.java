package project.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.domain.Books;

public class YourCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Books> bookCart;
		HttpSession session = request.getSession();
		bookCart = (ArrayList<Books>) session.getAttribute("bookCart");

		if (bookCart == null) {

			bookCart = new ArrayList<Books>();
			session.setAttribute("bookCart", bookCart);
		}

		String bookName = (String) request.getParameter("bookName");
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		Books book = new Books(bookName);
		book.setBookId(bookId);
		if (!bookCart.contains(book))
			bookCart.add(book);

		// Forward to to the JSP file.
		request.getRequestDispatcher("ViewAddedBooks.jsp").forward(request, response);

	}
}
