package project.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import project.domain.Author;
import project.domain.Books;
import project.domain.Name;

public class BookDatabase {
	private static DataSource bookDbDataSource = null;

	public static DataSource initDataSource() throws NamingException {
		Context initContext;

		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/bookrentaldb");
			return dataSource;
		} finally {
		}
	}

	public static Connection getConnection() throws NamingException, SQLException {
		Connection dbConn;

		if (bookDbDataSource == null) {
			bookDbDataSource = initDataSource();
		}

		dbConn = bookDbDataSource.getConnection();
		return dbConn;
	}

	public static ArrayList<Books> retrieveBookList() throws SQLException, NamingException {
		Connection dbConn;
		String retrieveStmt = "SELECT book.book_id, book_name, book_count, firstname, lastname FROM book, author where book.book_id = author.book_id";

		dbConn = getConnection();
		java.sql.Statement queryStmt = dbConn.createStatement();
		ResultSet results;
		ArrayList<Books> bookList = new ArrayList<Books>();
		results = queryStmt.executeQuery(retrieveStmt);

		while (results.next()) {

			int bookId = results.getInt("book_id");
			String bookName = results.getString("book_name");
			int bookCount = results.getInt("book_count");
			String authorFirstName = results.getString("firstname");
			String authorLastName = results.getString("lastname");

			Name authorName = new Name(authorFirstName, authorLastName);
			Author bookAuthor = new Author(authorName);

			Books book = new Books(bookName);
			book.setBookId(bookId);
			book.setBookCount(bookCount);
			book.setAuthor(bookAuthor);
			bookList.add(book);
		}
		results.close();
		queryStmt.close();
		return bookList;
	}

	public static void updateBookOut(int bookId) throws NamingException, SQLException {
		Connection dbConn;

		String updateStmt = "UPDATE book SET book_count = book_count -1 where book.book_id = " + bookId;

		dbConn = getConnection();
		java.sql.Statement queryStmt = dbConn.createStatement();
		queryStmt.executeUpdate(updateStmt);
		queryStmt.close();
	}

}
