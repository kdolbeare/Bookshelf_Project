package controllers;


import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Author;
import data.Book;
import data.BookDAO;

@Controller
@SessionAttributes("catalog")
public class BookshelfController
{
	@Autowired
	private BookDAO bookDAO;
	
	@ModelAttribute("catalog")
	public TreeSet<Book> initSessionBook()
	{
		TreeSet<Book> list = new TreeSet<>();
		return list;
	}
	
	@RequestMapping("listBooks.do")
	public ModelAndView getAllBooks()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("form.jsp");
		mv.addObject("book",bookDAO.getAllBooks());
		return mv;
	}
	@RequestMapping(path = "getByTitle.do", params = "title", method = RequestMethod.GET)
	public ModelAndView findBookByTitle(@RequestParam("title") String t, @ModelAttribute("catalog") TreeSet<Book> list)
	{
		TreeSet<Book> b = bookDAO.getBookByTitle(t);
		list.addAll(b);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("book.jsp");
		mv.addObject("book",bookDAO.getBookByTitle(t));
		return mv;
	}
	@RequestMapping(path="newBook.do", method=RequestMethod.POST)
	public String newBook (Book book, Author author, @ModelAttribute("catalog") TreeSet<Book> list)
	{
		book.setAuthor(author);
		author.setBook(book);
		bookDAO.addBook(book);
		list.add(book);
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("book.jsp");
		return "book.jsp";
	}
	@RequestMapping(path="deleteBook.do", params="title", method=RequestMethod.GET)
	public String deleteBook (@RequestParam("title") String t,@ModelAttribute("catalog") TreeSet<Book> list)
	{
		//System.out.println(bookDAO.getBookByTitle(t));
		list.remove(bookDAO.getOneBookByTitle(t));
		bookDAO.deleteBook(bookDAO.getOneBookByTitle(t));
		return "deleteBook.jsp";
	}
	@RequestMapping(path="editBook.do", params="title", method=RequestMethod.GET)
	public ModelAndView editBook (@RequestParam("title") String t)
	{
		Book b = (bookDAO.getOneBookByTitle(t));
//		Book b = new Book("Test");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editBook.jsp");
		mv.addObject("book", b);
		return mv;
	}
	//need to add another method to updateBook from the edit page
	@RequestMapping(path="editBook.do", method=RequestMethod.POST)
	public ModelAndView updateBook (@RequestParam("originalTitle") String o, @RequestParam("title") String t, @RequestParam("firstName") String f, 
			@RequestParam("lastName") String l, @RequestParam("numISBN") String n, @ModelAttribute("catalog") TreeSet<Book> list)
	{	
		//System.out.println(t + f+ l + n);
		
//		b.setTitle(t);
//		b.setNumISBN(n);
//		Author a = new Author(f,l);
//		b.setAuthor(a);		
//		bookDAO.addBook(b);
//		list.add(b);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("oneBook.jsp");
		mv.addObject("book", bookDAO.editBook(o, t,f,l, n));
		return mv;
	
		
	}
}
