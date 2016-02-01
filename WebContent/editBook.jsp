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
<title>Edit Book</title>
</head>
<body>
	<header>
	<div class="logo">
		<a href="index.html">Bookshelf</a>
	</div>
	<ul>
		<li><a href="newBook.do">Add Book</a></li>
		<li><a href="listBooks.do">List / Edit Books</a></li>
	</ul>
	</header>
	<form class="search" action="getByTitle.do" method="GET">
		<input type="text" placeholder="Enter Title" name="title">
		<button type="submit" value="submit" name="submit">Search</button>
	</form>
	<br>
	<h3>Edit a Book</h3>
	<form action="editBook.do" method="POST">
		<table class="edit">
			<tbody>
				<tr>
					<td>Title: <input name="title" value="${book.title}" /></td>
				</tr>
				<tr>
					<td>Author's first name:<input name="firstName"
						value="${book.author.firstName}" /></td>
				</tr>
				<tr>
					<td>Author's last name:<input name="lastName"
						value="${book.author.lastName}" /></td>
				</tr>
				<tr>
					<td>ISBN:<input name="numISBN" value="${book.numISBN}" /></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Update" />
	</form>

</body>
</html>