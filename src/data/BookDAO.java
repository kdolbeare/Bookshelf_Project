package data;

import java.util.List;
import java.util.TreeSet;

public interface BookDAO 
{
	public TreeSet<Book> getBookByTitle (String title);
	public TreeSet<Book> getAllBooks();
	public void addBook(Book book);
	public void deleteBook(Book book);
	public Book getOneBookByTitle(String title);
	public Book editBook(String original, String title, String firstName, String lastName, String numISBN);
}
