package com.comrade.booksapi.service;

import java.util.List;

import com.comrade.booksapi.entity.Author;

public interface AuthorService {
	public List<Author> findAll();

	public Author findBookByName(String name);

	public void save(Author author);

	public void delete(String name);
}
