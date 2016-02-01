package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class BookFileDAO implements BookDAO
{
	private static final String FILENAME = "WEB-INF/library.csv";
	private TreeSet<Book> books = new TreeSet<>();
	
	@Autowired
	private ApplicationContext ac;
	
	public BookFileDAO () {
		
	}	
	@PostConstruct
	public void loadBooksFromFile()
	{
		try (InputStream is = ac.getResource(FILENAME).getInputStream();
				BufferedReader buf = new BufferedReader(new InputStreamReader(is)))
		{
			String line;
			while ((line = buf.readLine()) != null)
			{
				String[] b = line.split(",");	
				Book book = new Book();
				book.setCategory(b[0].trim());
				book.setTitle(b[1].trim());
				Author a = new Author (b[2].trim(), b[3].trim());
				book.setAuthor(a);
				book.setNumISBN(b[4].trim());
				books.add(book);
				
			}
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
	@Override
	public TreeSet<Book> getBookByTitle(String title)
	{
		TreeSet<Book> b = new TreeSet<>();
		for (Book book : books)
		{
			if (book.getTitle().toLowerCase().contains(title.toLowerCase().trim()))
				b.add(book);				
		}
		return b;
	}	
	@Override
	public Book editBook (String title, String firstName, String lastName, String numISBN)
	{
		for (Book book : books)
		{
			if(book.getNumISBN().trim().equals(numISBN.trim()))
			{
				book.setTitle(title);
				book.setNumISBN(numISBN);
				Author a = new Author (firstName, lastName);
				book.setAuthor(a);
				return book;
			}				
		}return null;
	}	
	@Override
	public Book getOneBookByNum(String numISBN)
	{
		for (Book book : books)
		{
			if (book.getNumISBN().contains(numISBN.trim()))
				return book;			
		}
			return null;
	}
	@Override
	public TreeSet<Book> getAllBooks()
	{
		return books;
	}	
	@Override
	public void addBook(Book book)
	{
		books.add(book);
	}
	@Override
	public void deleteBook(Book book)
	{
		if (books.contains(book))		
			books.remove(book);
	}
}
