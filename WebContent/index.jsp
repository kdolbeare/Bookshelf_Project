<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="normalize.css">
<link rel="stylesheet" href="book.css">
<meta charset="UTF-8">
<title>Bookshelf</title>
</head>
<body>
	<header>
		<div class="logo">
			<a href="index.jsp">Bookshelf</a>
		</div>
	<ul>		
		<!-- keeping for future reference: <li><a href="editBook.do?title=A+Beautiful+Mind">Edit Book</a></li> -->	
		<li><a href="newBook.do">Add Book</a></li>
		<li><a href="listBooks.do">List / Edit Books</a></li>
	</ul>		
	</header>
	<form class="search" action="getByTitle.do" method="GET">
		 <input type="text" placeholder="Enter Title" name="title"> 
		 <button type="submit" value="submit" name="submit">Search</button>
	</form>
</body>
</html>