<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.*" import="project.domain.*"%>

<title>TransactionCompleted</title>
<%
	String bookName = null;
	ArrayList<Books> bookList = (ArrayList<Books>) request.getSession().getAttribute("bookCart");
%>
</head>
<body bgcolor="#E6E6FA">
	<h2>Congratulations! You've Successfully Rented following Books:</h2>
	<br>
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

	<label style="font-size: large; font-weight: bold; color: green;">for
		${rentalTime}.</label>

	<%
		request.getSession().invalidate();
	%>

	<h3>
		You'll no longer have Access to these books after the selected
		Duration is Completed. <br> Thank You!
	</h3>


</body>
</html>