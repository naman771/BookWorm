package com.comrade.booksapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comrade.booksapi.dao.BookDao;
import com.comrade.booksapi.entity.Book;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> findAll(){
		return bookDao.findAll();
	}

	@Override
	public Book findByCode(int bookCode) {
		return bookDao.findBooksByCode(bookCode);
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void deleteBook(int bookCode) {
		bookDao.deleteBook(bookCode);
	}
}
