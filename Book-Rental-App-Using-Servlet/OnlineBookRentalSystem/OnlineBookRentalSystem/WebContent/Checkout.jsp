<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.*" import="project.domain.*"%>

<title>Checkout</title>
<%
	String bookName = null;
	int bookId;
	ArrayList<Books> bookList = (ArrayList<Books>) request.getSession().getAttribute("bookCart");
%>
</head>
<body bgcolor="#E6E6FA">

	<br>

	<p>NOTE: Please do not hold the books for longer duration than you
		actually need.</p>
	<p>The Books you Selected are:</p>
	<%
		if (bookList != null && !bookList.isEmpty()) {
			for (Books book : bookList) {
				bookName = book.getName();
	%>
	<label style="font-size: large; font-weight: bold; color: green;"><%=bookName%></label>
	<br>
	<%
		}
		}
	%>
	<form method='post' action='TransactionCompleted.html'>
		<h1>Please select how long you want to rent</h1>
		<input type="hidden" name="bookName" value="${bookName}" /> <select
			name="rentalTime">
			<option value="1 Month">1 Month</option>
			<option value="2 Month">2 Month</option>
			<option value="3 Month">3 Month</option>
		</select> <input type='submit' value='Continue' />
	</form>
	<br>


</body>
</html>