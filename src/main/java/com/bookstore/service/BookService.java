package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;

public interface BookService {

	int insertBook(Book book);

	List<Book> getAllBooks();

	int deleteBook(int bookId);

	int updateBook(int bookId, Book book);

}
