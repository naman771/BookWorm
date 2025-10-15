package com.comrade.booksapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comrade.booksapi.dao.AuthorDao;
import com.comrade.booksapi.entity.Author;

@Service("authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorDao authorDao;
	
	@Override
	public List<Author> findAll(){
		return authorDao.findAll();
	}
	
	@Override
	public Author findBookByName(String name) {
		return authorDao.findBookByName(name);
	}

	public void save(Author author) {
		 authorDao.save(author);
	}

	public void delete(String name) {
		authorDao.delete(name);
	}

}
