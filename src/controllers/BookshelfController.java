package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<Book> initSessionBook()
	{
		List<Book> list = new ArrayList<>();
		return list;
	}
	
	@RequestMapping("GetAllBooks.do")
	public ModelAndView getAllBooks()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("form.jsp");
		mv.addObject("book",bookDAO.getAllBooks());
		return mv;
	}
	

}
