
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.*" import="project.domain.*"%>

<title>Your Cart</title>

<%
	String bookName = null;
	int bookId;
	ArrayList<Books> bookList = (ArrayList<Books>) request.getSession().getAttribute("bookCart");
%>
</head>

<body bgcolor="#E6E6FA">
	<p>You are viewing your cart:</p>
	<%
		if (bookList != null && !bookList.isEmpty()) {
			for (Books book : bookList) {
				bookName = book.getName();
				bookId = book.getBookId();
	%>
	<label style="font-size: large; font-weight: bold; color: green;"><%=bookName%></label>
	<br>
	<%
		}
		} else {
	%>
	<label style="color: red; font-style: italic;">Your cart is
		currently empty.</label>
	<%
		}
	%>

	<table>
		<tr>
			<td colspan="2">
				<form method='post' action='BookList.html'>
					<input type='submit' value='Add more Books' />
				</form>

			</td>
			<td>

				<form method='post' action='Checkout.html'>
					<input type="hidden" name="bookName" value="${book.name}" /> <input
						type="hidden" name="bookId" value="${book.bookId}" /> <input
						type='submit' value='Proceed To Checkout' />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>

