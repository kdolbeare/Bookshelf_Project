package controllers;


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
	//for the drop down list
	@RequestMapping(path="newBook.do", method=RequestMethod.GET)
	public ModelAndView newBook()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("newBook.jsp");
		mv.addObject("book", bookDAO.getAllBooks());
		return mv;
	}
	@RequestMapping(path="newBook.do", method=RequestMethod.POST)
	public ModelAndView newBook (Book book, Author author, @ModelAttribute("catalog") TreeSet<Book> list)
	{
		book.setAuthor(author);
		author.setBook(book);
		bookDAO.addBook(book);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("oneBook.jsp");
		return mv;
	}
	@RequestMapping(path="deleteBook.do", params="numISBN", method=RequestMethod.GET)
	public String deleteBook (@RequestParam("numISBN") String n,@ModelAttribute("catalog") TreeSet<Book> list)
	{
		try{
		list.remove(bookDAO.getOneBookByNum(n));
		bookDAO.deleteBook(bookDAO.getOneBookByNum(n));
		}catch(Exception e)
		{
			System.out.println("book not found: " + e);
		}
		return "deleteBook.jsp";
	}
	@RequestMapping(path="editBook.do", params="numISBN", method=RequestMethod.GET)
	public ModelAndView editBook (@RequestParam("numISBN") String n)
	{
		Book b = (bookDAO.getOneBookByNum(n));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editBook.jsp");
		mv.addObject("book", b);
		return mv;
	}
	@RequestMapping(path="editBook.do", method=RequestMethod.POST)
	public ModelAndView updateBook (@RequestParam("title") String t, @RequestParam("firstName") String f, 
			@RequestParam("lastName") String l, @RequestParam("numISBN") String n, @ModelAttribute("catalog") TreeSet<Book> list)
	{	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("oneBook.jsp");
		mv.addObject("book", bookDAO.editBook(t,f,l, n));
		return mv;		
	}
}
