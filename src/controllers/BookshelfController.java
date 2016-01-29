package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Book;
import data.BookDAO;

@Controller
@SessionAttributes("catalog")
public class BookshelfController
{
	@Autowired
	private BookDAO bookDAO;
	
	@ModelAttribute("catalog")
	public HashSet<Book> initSessionBook()
	{
		HashSet<Book> list = new HashSet<>();
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
	public ModelAndView findBookByTitle(@RequestParam("title") String t, @ModelAttribute("catalog") HashSet<Book> list)
	{
		Book b = bookDAO.getBookByTitle(t);
		list.add(b);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("book.jsp");
		mv.addObject("book",bookDAO.getBookByTitle(t));
		return mv;
	}
	@RequestMapping(path="newBook.do", method=RequestMethod.POST)
	public ModelAndView newBook (Book book, @ModelAttribute("catalog") HashSet<Book> list)
	{
		//there's another annotation??
		bookDAO.addBook(book);
		list.add(book);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("book.jsp");
		return mv;
	}
	

}
