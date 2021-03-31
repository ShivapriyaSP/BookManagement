package com.mindtree.BooksManagementApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.BooksManagementApp.Entity.Book;
import com.mindtree.BooksManagementApp.Entity.Writer;
import com.mindtree.BooksManagementApp.Service.BookManagementService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookManagementService service;
	
	@PostMapping("/addBook")
	public ResponseEntity<?> addBook(@RequestBody Book book)
	{
		Book b=service.addBook(book);
		return new ResponseEntity<Book>(b,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/getBookBasedOnPrice")
	public List<Book> getBooksBasedOnPrice()
	{
		List<Book> books = service.getBooksBasedOnPrice();
		return books;
	}
	
}
