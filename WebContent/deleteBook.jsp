<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="normalize.css">
<link rel="stylesheet" href="book.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Book</title>
</head>
<body>
<header>
<div class="logo">
	<a href="index.jsp">Bookshelf</a>
	</div>
	<ul>
		<li><a href="newBook.do">Add Book</a></li>
		<li><a href="listBooks.do">List / Edit Books</a></li>			
	</ul>
	</header>
	<form class="search" action="getByTitle.do" method="GET">
		 <input type="text" placeholder="Enter Title" name="title"> 
		 <button type="submit" value="submit" name="submit">Search</button>
	</form><br>
	<p>Book Deleted</p>
	<!-- <h3>Delete a Book</h3>
	<form action="deleteBook.do" method="GET">
		<input type="text" name ="title" placeholder = "title to delete"/>
		<input type="submit" value="Delete" />
	</form> -->

</body>
</html>