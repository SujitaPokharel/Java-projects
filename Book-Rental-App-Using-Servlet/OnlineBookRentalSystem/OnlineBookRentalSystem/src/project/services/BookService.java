package project.services;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import project.database.BookDatabase;
import project.domain.Books;

public class BookService {
	private ArrayList<Books> bookList;

	public ArrayList<Books> getBookList() throws SQLException, NamingException {
		if (bookList == null) {
			bookList = BookDatabase.retrieveBookList();
		}
		return bookList;
	}

	public void updateBookCheckedOut(int bookId) throws NamingException, SQLException {
		BookDatabase.updateBookOut(bookId);
	}

}