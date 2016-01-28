package data;

import java.util.List;

public interface BookDAO
{
	public Book getBookTitle (String title);
	public List<Book> getAllBooks();
}
