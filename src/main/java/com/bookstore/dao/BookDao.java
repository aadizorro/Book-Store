package com.bookstore.dao;

import java.util.List;

import com.bookstore.model.Book;

public interface BookDao {

	boolean checkBook(String title);

	int insertBook(Book book);

	List<Book> getAllBooks();

	int deleteBook(int bookId);

	boolean checkBook(int bookId);

	int updateBook(int bookId, Book book);

}
