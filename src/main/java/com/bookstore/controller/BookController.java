package com.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private  BookService bookService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testBookController() {
		return "Test Book controller is working.";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int insertBook(@RequestBody Book book) {
		try {
			return bookService.insertBook(book);
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getAllBooks(){
		try {
			List<Book> books = bookService.getAllBooks();
			for(Book book:books) {
				System.out.println(book.toString());
			}
			return books;
		}
		catch(Exception e) {
			return new ArrayList<Book>();
		}
	}
	
	@RequestMapping(value = "/delete/{bookId}",method = RequestMethod.DELETE)
	public  int deleteBook(@PathVariable int bookId) {
		try {
			return bookService.deleteBook(bookId);
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value = "/update/{bookId}",method = RequestMethod.PUT)
	public int updateBook(@PathVariable int bookId, @RequestBody Book book) {
		try {
			return bookService.updateBook(bookId,book);
		}
		catch(Exception e) {
			return 0;
		}
		
	}
}
