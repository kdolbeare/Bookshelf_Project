<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Book</title>
</head>
<body>
	<h3>Add a New Book</h3>
	<!-- ask Jamie about the author -->
	<form action="newBook.do" method="POST">
		Title:
		<input type="text" name="title"><br/>
		Author fName:
		<input type="text" name="firstName"/><br/>
		Author lName: 
		<input type="text" name="lastName"/><br/>
		<input type="submit" value="Add Book" />
	</form>

</body>
</html>