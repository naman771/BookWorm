package com.comrade.booksapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comrade.booksapi.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void addBook(Book book) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(book);
	}

	@Override
	public Book findBooksByCode(int code) {

		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from books where bookCode=:code");
		query.setParameter("bookCode", code);
		Book result = (Book) query.uniqueResult();
		return result;

	}

	public void deleteBook(int bookCode) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from books where bookCode=:bookCode");
		query.setParameter("bookCode", bookCode);
	}

	public List<Book> findAll() {
		Session session = entityManager.unwrap(Session.class);

		Query<Book> query = session.createQuery("from Book", Book.class);

		List<Book> books = query.getResultList();

		return books;
	}
}
