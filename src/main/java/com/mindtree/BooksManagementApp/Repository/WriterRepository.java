package com.mindtree.BooksManagementApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.BooksManagementApp.Entity.Writer;
@Repository
public interface WriterRepository extends JpaRepository<Writer,Integer>{

}
