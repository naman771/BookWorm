package com.comrade.booksapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comrade.booksapi.entity.Book;
import com.comrade.booksapi.service.BookService;

@RestController
@RequestMapping("/api")
public class BookRestController {

	@Autowired
	private BookService bookservice;

	@GetMapping("/books")
	public List<Book> findAll(){
		return bookservice.findAll();
	}
	
	@GetMapping("/books/{bookCode}")
	public Book findBookByCode(@PathVariable int bookCode) {
		Book book=bookservice.findByCode(bookCode);
		
		if(book==null) {
			throw new RuntimeException("No Book found with code-"+ bookCode);
		}
		return book;
	}
	
	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book) {
		bookservice.addBook(book);
		return book;
	}
	
	@DeleteMapping("/books/{bodeCode}")
	public String deleteBook(@PathVariable int bookCode) {
		Book book=bookservice.findByCode(bookCode);
		if(book==null) {
			throw new RuntimeException("No Book found with code-"+ bookCode);
		}
		bookservice.deleteBook(bookCode);
		return "book delete with code"+ bookCode;
	}
}
