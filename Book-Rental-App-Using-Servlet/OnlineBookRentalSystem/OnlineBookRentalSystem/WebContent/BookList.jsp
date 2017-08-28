<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.*" import="project.domain.*"%>
<%
	String bookName = null;
	String authorName = null;
	int bookId;
	ArrayList<Books> bookList = (ArrayList<Books>) request.getAttribute("bookList");
%>

<head>
<title>List of available Books</title>
</head>
<body bgcolor="#E6E6FA">
	<h1>Current Available Books:</h1>
	<%
		if (bookList == null || bookList.size() == 0) {
	%>
	No courses available at this time
	<%
		} else {
	%>
	<ul>
		<%
			for (Books curAvlBooks : bookList) {
					bookId = curAvlBooks.getBookId();
					bookName = curAvlBooks.getBookName();
					authorName = curAvlBooks.getAuthor().toString();
		%>
		<li>
			<form method='post' action='addCourseToCart.html'>
				<b><%=bookName + authorName%></b>&nbsp;&nbsp; <input type='hidden'
					name='bookName' value='<%=bookName + authorName%>' /> <input
					type='hidden' name='bookId' value='<%=bookId%>' />

				<%
					if (curAvlBooks.isAvailable()) {
				%>
				<input type='submit' value='Add To Cart' />
				<%
					} else {
				%>
				<label style="color: red; font-style: italic;"> Currently
					unavailable.</label>
				<%
					}
				%>
			</form> <br>
		</li>
		<%
			}
		%>
	</ul>
	<%
		}
	%>

</body>
</html>
