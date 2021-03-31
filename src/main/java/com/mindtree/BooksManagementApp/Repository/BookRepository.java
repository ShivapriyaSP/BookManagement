package com.mindtree.BooksManagementApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.BooksManagementApp.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

	@Query("select b from Book b where b.name = ?1")
	Book findByName(String bookName);
}
