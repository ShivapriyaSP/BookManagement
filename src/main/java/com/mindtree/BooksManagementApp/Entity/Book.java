package com.mindtree.BooksManagementApp.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	private String name;
	private double price;
	
	@OneToMany(mappedBy="book")
	private List<Writer> writers;
	
	public Book()
	{}
	
	public Book(int bookId, String name, double price) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Writer> getWriters() {
		return writers;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}
	
	
}
