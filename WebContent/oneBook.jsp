<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="normalize.css">
<link rel="stylesheet" href="book.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalog</title>
</head>
<body>
	<header>
	<div class="logo">
		<a href="index.html">Bookshelf</a>
	</div>
	<ul>
		<li><a href="deleteBook.jsp">Delete Book</a></li>	
		<li><a href="newBook.jsp">Add Book</a></li>
		<li><a href="listBooks.do">List / Edit Books</a></li>
	</ul>
	</header>
	<form class="search" action="getByTitle.do" method="GET">
		 <input type="text" placeholder="Enter Title" name="title"> 
		 <button type="submit" value="submit" name="submit">Search</button>
	</form><br>      
	<h3>Updated Book</h3>
	<c:choose>
		<c:when test="${! empty book}">
			<table>
				<tr>
					<th colspan="2">Title: ${book.title}</th>
				</tr>
				<tbody>
					<tr>
						<td>Category:</td>
						<td>${book.category}</td>
					</tr>
					<%-- <tr><td>Title:</td><td>${book.title}</td></tr> --%>
					<tr>
						<td>Author:</td>
						<td>${book.author}</td>
					</tr>
					<tr>
						<td>ISBN:</td>
						<td>${book.numISBN}</td>
					</tr>
				</tbody>
			</table>
			<form action="editBook.do" method=GET>
				<input type="hidden" name="title" value="${book.title}"> <input
					type="submit" value="edit">
			</form>
		</c:when>
		<c:otherwise>
			<p>No book found</p>
		</c:otherwise>
	</c:choose>

</body>
</html>