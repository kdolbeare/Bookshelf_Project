<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Book</title>
</head>
<body>
<header>
<div class="logo">
	<a href="index.html">Bookshelf</a>
	</div>
	<ul>
		<li><a href="listBooks.do">List Books</a></li>
		<li><a href="newBook.jsp">Add Book</a></li>
		<li><a href="deleteBook.jsp">Delete Book</a></li>
		<li><a href="listBooks.do">Edit Books</a></li>
		
		
	</ul>	
	</header>
	<h3>Delete a Book</h3>
	<form action="deleteBook.do" method="GET">
		<input type="text" name ="title" placeholder = "title to delete"/>
		<input type="submit" value="Delete Book" />
	</form>

</body>
</html>