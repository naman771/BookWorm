package com.comrade.booksapi.dao;

import java.util.List;

import com.comrade.booksapi.entity.Author;

public interface AuthorDao {
	public List<Author> findAll();
	public Author findBookByName(String name);
	public void delete(String name);
	public void save(Author author);
}
