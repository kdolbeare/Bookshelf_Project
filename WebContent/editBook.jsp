<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Book</title>
</head>
<body>
	<h3>Edit a Book</h3>
	<form action="editBook.do" method="POST">
		<table>
			<tr>
				<td>Title: <input name="title" value="${book.title}"/></td>
				<td>Title: <input type="hidden" name="originalTitle" value="${book.title}"/></td>
			</tr>
			<tr>
				<td>Author's first name:<input name="firstName" value="${book.author.firstName}" /></td>
			</tr>
			<tr>
				<td>Author's last name:<input name="lastName" value="${book.author.lastName}"/></td>
			</tr>
			<tr>
				<td>ISBN:<input name="numISBN" value="${book.numISBN}"/></td>
			</tr>
		</table>
		<input type="submit" value="Update Book" />
	</form>

</body>
</html>