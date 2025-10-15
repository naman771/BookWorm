package com.comrade.booksapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comrade.booksapi.entity.Author;

@Repository
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public void save(Author author) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(author);
	}

	@Override
	public void delete(String name) {
		Session session = entityManager.unwrap(Session.class);

		Query query = session.createQuery("delete from Author where name=:name");
		query.setParameter("name", name);
		query.executeUpdate();
	}
	@Override
	public List<Author> findAll(){
		Session session = entityManager.unwrap(Session.class);
		Query query=session.createQuery("from Author",Author.class);
		List<Author>authorList=query.getResultList();
		return authorList;
	}
	
	@Override
	public Author findBookByName(String name) {
		Session session = entityManager.unwrap(Session.class);
		Query query=session.createQuery("from Author where name=:name");
		query.setParameter("name", name);
		Author result=(Author) query.uniqueResult();
		return result;
	}
}
