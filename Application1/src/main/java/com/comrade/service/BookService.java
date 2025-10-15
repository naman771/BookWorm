package com.comrade.service;

import java.util.List;

import com.comrade.model.Book;

public interface BookService {
	public List<Book> listBooks();
	public Book getBookByBookCode(int bookCode);
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(int bookCode);
}
