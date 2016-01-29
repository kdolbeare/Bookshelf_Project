<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Book</title>
</head>
<body>
	<h3>Delete a Book</h3>
	<form action="deleteBook.do" method="GET">
		<input type="text" name ="title" value = "title"/>
		<input type="submit" value="Delete Book" />
	</form>

</body>
</html>