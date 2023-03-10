package com.xtglobal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xtglobal.bindings.Book;
import com.xtglobal.service.BookService;

public class BookRestController
{
	@Autowired
	private BookService bookService;
	
	@PostMapping(value="/addbook", consumes= {"application/json"})
	public ResponseEntity<String> addBook(@RequestBody Book book)
	{
		String msg = null;
		boolean isSaved = bookService.saveBook(book);
		if(isSaved)
		{
			msg ="Book saved";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		return null;
		 
	}
	
	
	
	
}
