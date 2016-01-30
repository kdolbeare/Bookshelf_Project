<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link rel="stylesheet" href="style.css"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalog</title>
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

	<h4>All Books</h4>
	<c:choose>
		<c:when test="${! empty book}">
		<c:forEach var="book" items="${book}">
			<table>
			<tr><th colspan="2"></th></tr>
			<tbody>
				<tr><td>Category:</td><td>${book.category}</td></tr>
				<tr><td>Title:</td><td>${book.title}</td></tr>
				<tr><td>Author:</td><td>${book.author}</td></tr>
				<tr><td>ISBN:</td><td>${book.numISBN}</td></tr>
			</tbody>
			</table>
			<form action="editBook.do" method=GET>
			<input type="hidden" name="title" value="${book.title}">
			<input type="submit" value="edit">
			</form>
			<form action="deleteBook.do" method=GET>
			<input type="hidden" name="title" value="${book.title}">
			<input type="submit" value="delete book now">
			</form>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>No book found</p>
		</c:otherwise>
	</c:choose>
		
</body>
</html>