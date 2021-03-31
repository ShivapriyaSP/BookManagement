package com.mindtree.BooksManagementApp.Service.serviceImpl;

import java.util.Comparator;

import com.mindtree.BooksManagementApp.Entity.Book;

public class SortByPrice implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return (int) ((o1.getPrice()-o2.getPrice())*-1);
	}
	

}
