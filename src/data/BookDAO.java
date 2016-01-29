package data;

import java.util.List;

public interface BookDAO
{
	public Book getBookByTitle (String title);
	public List<Book> getAllBooks();
	public void addBook(Book book);
}
