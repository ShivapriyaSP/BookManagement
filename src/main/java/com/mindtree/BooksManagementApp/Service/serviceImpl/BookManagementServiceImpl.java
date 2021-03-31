package com.mindtree.BooksManagementApp.Service.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.BooksManagementApp.Entity.Book;
import com.mindtree.BooksManagementApp.Entity.Writer;
import com.mindtree.BooksManagementApp.Exception.NoBookFoundException;
import com.mindtree.BooksManagementApp.Repository.BookRepository;
import com.mindtree.BooksManagementApp.Repository.WriterRepository;
import com.mindtree.BooksManagementApp.Service.BookManagementService;

@Service
public class BookManagementServiceImpl implements BookManagementService{

	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private WriterRepository writerrepository;
	@Override
	public Book addBook(Book book) {
		Book b = bookrepository.save(book);
		return b;
	}
	@Override
	public Writer addWriter(Writer writer, String bookName) throws NoBookFoundException {
//		Book b = bookrepository.findByName(bookName);
//		//Optional<Book> b = bookrepository.findByName(bookName).orElseThrow(()-> new NoBookFoundException("Book with the name was not found"));
		Writer w = new Writer();
//		if(b!=null)
//		{
//			//System.out.println("Please map");
//			w.setBook(b);
//			w = writerrepository.save(w);
//		}
//		else
//			System.out.println("try again and change to orelsethrow");
//		return w;
		List<Book> books = bookrepository.findAll();
		//Book book = books.stream().filter(b->b.getName().equals(bookName)).orElseThrow(()->new NoBookFoundException("Book with the name was not found"));
//		try {
		Book bk= books.stream().filter(b->b.getName().equals(bookName)).findFirst().orElseThrow(()->new NoBookFoundException("Book with the name was not found"));
		writer.setBook(bk);
		List<Writer> wr = bk.getWriters();
		wr.add(writer);
		bk.setWriters(wr);
		w = writerrepository.save(writer);
//		}
		return w;
	}
	@Override
	public List<Book> getBooksBasedOnPrice() {
		List<Book> books = new ArrayList<>();
		books = bookrepository.findAll();
		List<Book> b = books.stream().filter((ob)-> {if(ob.getPrice()>=500)
														return true;
													else
														return false;}).collect(Collectors.toList());
		Collections.sort(b,new SortByPrice());
		return b;
	}
}
