<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="normalize.css">
<link rel="stylesheet" href="book.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Book</title>
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
	<h3>Add a New Book</h3>
	<form action="newBook.do" method="POST">
		<select class="drop" name="category">
			<c:forEach var="book" items="${book}">
				<option value="${book.category}">${book.category}</option>
			</c:forEach>
		</select><br> <input type="text" name="title" placeholder="Title"><br />
		<input type="text" name="firstName" placeholder="First Name" /><br />
		<input type="text" name="lastName" placeholder="Last Name" /><br /> <input
			type="text" name="numISBN" placeholder="10 digit ISBN" /><br /> <input
			type="submit" value="Add Book" />
	</form>

</body>
</html>