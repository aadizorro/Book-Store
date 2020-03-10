package com.bookstore;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.dao.BookDao;
import com.bookstore.model.Book;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean checkBook(String title) {
		List<Book> book = sessionFactory.getCurrentSession().createQuery("From Book where title = :title")
				.setParameter("title", title).list();
		if (book.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int insertBook(Book book) {
		int bookId = (int) sessionFactory.getCurrentSession().save(book);
		return bookId;

	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = sessionFactory.getCurrentSession().createQuery("From Book").list();
		if (books.size() > 0) {
			System.out.println(books.size());
			return books;
		}
		return null;
	}

	@Override
	public int deleteBook(int bookId) {
		if (checkBook(bookId)) {
			return (int) sessionFactory.getCurrentSession().createQuery("Delete  from Book where Id = :bookId")
					.setParameter("bookId", bookId).list().get(0);
		}
		return 0;
	}

	@Override
	public boolean checkBook(int bookId) {
		List<Book> books = sessionFactory.getCurrentSession().createQuery("From Book where Id = :bookId")
				.setParameter("bookId", bookId).list();
		if (books.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int updateBook(int bookId, Book book) {
		if (checkBook(bookId)) {
			List<Book> book_list = sessionFactory.getCurrentSession().createQuery("From Book where Id = :bookId")
					.setParameter("bookId", bookId).list();
			book_list.get(0).setAuthor(book.getAuthor());
			book_list.get(0).setAuthor(book.getTitle());
			book_list.get(0).setPrice(book.getPrice());

			return (int) sessionFactory.getCurrentSession().save(book_list.get(0));
		}
		return 0;
	}

}
