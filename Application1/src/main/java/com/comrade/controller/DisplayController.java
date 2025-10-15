package com.comrade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comrade.model.Author;
import com.comrade.model.Book;
import com.comrade.service.AuthorService;
import com.comrade.service.BookService;

@Controller
public class DisplayController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;

	@RequestMapping("/display")
	public ModelAndView display(HttpServletRequest request, HttpServletResponse response) {
		List<Book> bookList = bookService.listBooks();
		request.setAttribute("bookList", bookList);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		return mv;
	}
	
	@RequestMapping("/addBookForm")
	public ModelAndView addBookForm(HttpServletRequest request, HttpServletResponse response) {
		List<Author> authorList = authorService.findAll();
		request.setAttribute("authorList", authorList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add");
		return mv;
	}
	
	@RequestMapping("/editBookForm")
	public ModelAndView editBookForm(HttpServletRequest request, HttpServletResponse response) {
		List<Author> authorList = authorService.findAll();
		request.setAttribute("authorList", authorList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit");
		return mv;
	}
}
