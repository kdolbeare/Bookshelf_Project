package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class BookFileDAO implements BookDAO
{
	private static final String FILENAME = "WEB-INF/library.csv";
	private List<Book> books = new ArrayList<>();
	
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
		System.out.println(books.size());
	}
	
	
	@Override
	public Book getBookByTitle(String title)
	{
		for (Book book : books)
		{
			if(book.getTitle().trim().equalsIgnoreCase(title.trim()))
				return book;
			else if (book.getTitle().toLowerCase().contains(title.toLowerCase().trim()))
				return book;
		}
		return null;
	}

	@Override
	public List<Book> getAllBooks()
	{
		return books;
	}
	
	@Override
	public void addBook(Book book)
	{
		books.add(book);
	}

}
