package com.bookstore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.BookDao;
import com.bookstore.model.Book;
import com.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public int insertBook(Book book) {
		if(!bookDao.checkBook(book.getTitle())) {
			return bookDao.insertBook(book);
		}
		return 0;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = bookDao.getAllBooks();
		if(books.size() > 0) {
			System.out.println(books.size());
			return books;
		}
		return null;
	}

	@Override
	public int deleteBook(int bookId) {
		if(bookDao.checkBook(bookId)) {
			return bookDao.deleteBook(bookId);
		}
		return 0;
	}

	@Override
	public int updateBook(int bookId, Book book) {
		if(bookDao.checkBook(bookId)) {
			return bookDao.updateBook(bookId, book);
		}
		return 0;
	}

}
