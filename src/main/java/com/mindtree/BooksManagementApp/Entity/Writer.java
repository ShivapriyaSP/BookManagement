package com.mindtree.BooksManagementApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Writer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int writerId;
	@NotNull(message="name should not be blank")
	private String writerName;
	
	@ManyToOne
	@JsonIgnore
	private Book book;
	public Writer()
	{}
	
	public Writer(int writerId, String writerName) {
		super();
		this.writerId = writerId;
		this.writerName = writerName;
	}

	public int getWriterId() {
		return writerId;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
