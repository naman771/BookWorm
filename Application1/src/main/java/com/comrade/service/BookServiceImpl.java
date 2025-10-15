package com.comrade.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.comrade.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_ALL_BOOKS_API = "http://localhost:8081/api/books";
	private static final String GET_BOOK_BY_CODE_API = "http://localhost:8081/api/books/";
	private static final String CREATE_BOOK_API = "http://localhost:8081/api/books";
	private static final String UPDATE_BOOK_API = "http://localhost:8081/api/books";
	private static final String DELETE_BOOK_API = "http://localhost:8081/api/books/";

	@Override
	public List<Book> listBooks() {
		Book[] bookListArray = restTemplate.getForObject(GET_ALL_BOOKS_API, Book[].class);
		List<Book> bookList = Arrays.asList(bookListArray);
		return bookList;
	}

	@Override
	public Book getBookByBookCode(int bookCode) {
		Book book = restTemplate.getForObject(GET_BOOK_BY_CODE_API, Book.class);
		return book;
	}

	@Override
	public void addBook(Book book) {
		System.out.println("Added book" + restTemplate.postForObject(CREATE_BOOK_API, book, Book.class));
	}

	@Override
	public void updateBook(Book book) {
		restTemplate.put(UPDATE_BOOK_API, book);
	}

	@Override
	public void deleteBook(int bookCode) {
		restTemplate.delete(DELETE_BOOK_API + Integer.toString(bookCode));
	}
}
