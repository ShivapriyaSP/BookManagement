package com.mindtree.BooksManagementApp.Controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.BooksManagementApp.Entity.Writer;
import com.mindtree.BooksManagementApp.Exception.NoBookFoundException;
import com.mindtree.BooksManagementApp.Service.BookManagementService;

@RestController
@Validated
@RequestMapping("/writer")
public class WriterController {

	@Autowired
	private BookManagementService service;
	
	@PostMapping("/addWriter/{bookName}")
	public ResponseEntity<?> addWriter(@RequestBody @Valid Writer writer,@PathVariable @NotBlank(message="mention the book name") String bookName)
	{
		
		try {
		Writer w = service.addWriter(writer,bookName);
		return new ResponseEntity<Writer>(w,HttpStatus.ACCEPTED);
		}
		catch(NoBookFoundException e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			//throw new ControllerE
		}
	}
}
