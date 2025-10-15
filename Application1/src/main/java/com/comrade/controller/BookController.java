package com.comrade.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comrade.model.Book;
import com.comrade.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		Book book = new Book();
		int bookCode = Integer.parseInt(request.getParameter("bookCode"));
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		LocalDate todayDate = LocalDate.now();
		System.out.println("Today's Date:" + todayDate);
		Date dateAdded=Date.valueOf(todayDate);
		
		System.out.println(dateAdded);

		book.setBookCode(bookCode);
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setDateAdded(dateAdded);
		System.out.println(book);
		
		bookService.addBook(book);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/display");
		return mv;
	}

	@PostMapping("/edit/{bookCode}")
	public ModelAndView edit(@PathVariable int bookCode, HttpServletRequest request, HttpServletResponse response) {
		Book book = bookService.getBookByBookCode(bookCode);
		request.setAttribute("book", book);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/editBookForm");
		return mv;
	}

	@PostMapping("/delete/{bookCode}")
	public ModelAndView deleteBook(@PathVariable int bookCode, HttpServletRequest request,
			HttpServletResponse response) {
		bookService.deleteBook(bookCode);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/display");
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		Book book = new Book();
		int bookCode = Integer.parseInt(request.getParameter("bookCode"));
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		LocalDate todayDate = LocalDate.now();
		System.out.println("Today's Date:" + todayDate);
		Date dateAdded = Date.valueOf(todayDate);

		book.setBookCode(bookCode);
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setDateAdded(dateAdded);
		bookService.updateBook(book);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/display");
		return mv;
	}
}
