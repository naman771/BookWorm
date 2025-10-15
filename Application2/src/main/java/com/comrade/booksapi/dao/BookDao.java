package com.comrade.booksapi.dao;

import java.util.List;

import com.comrade.booksapi.entity.Book;

public interface BookDao {
	public void addBook(Book book);
	public Book findBooksByCode(int bookCode);
	public void deleteBook(int bookCode);
	public List<Book>findAll();
	
}
