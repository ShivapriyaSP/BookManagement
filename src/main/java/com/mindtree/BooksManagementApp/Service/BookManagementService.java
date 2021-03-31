package com.mindtree.BooksManagementApp.Service;


import java.util.List;

import com.mindtree.BooksManagementApp.Entity.Book;
import com.mindtree.BooksManagementApp.Entity.Writer;
import com.mindtree.BooksManagementApp.Exception.NoBookFoundException;

public interface BookManagementService {

	Book addBook(Book book);

	Writer addWriter(Writer writer, String bookName) throws NoBookFoundException;

	List<Book> getBooksBasedOnPrice();

}
