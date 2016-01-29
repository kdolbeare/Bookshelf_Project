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
	<form action="getByTitle.do" method="GET">
		 <input type="text" placeholder="Enter Title" name="title"> 
		 <button type="submit" value="submit" name="submit">Search Shelf</button>
	</form>
	<c:choose>
		<c:when test="${! empty book}">
		<c:forEach var="book" items="${catalog}">
			<table>
			<tr><th colspan="2"></th></tr>
			<tbody>
				<tr><td>Category:</td><td>${book.category}</td></tr>
				<tr><td>Title:</td><td>${book.title}</td></tr>
				<tr><td>Author:</td><td>${book.author}</td></tr>
				<tr><td>ISBN:</td><td>${book.numISBN}</td></tr>
			</tbody>
			</table>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>No book found</p>
		</c:otherwise>
	</c:choose>
		
</body>
</html>