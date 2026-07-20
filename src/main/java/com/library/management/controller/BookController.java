package com.library.management.controller;

import java.util.*;

import com.library.management.model.Book;
import com.library.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping
	public List<Book> getAllBooks() {
	    return service.getAllBooks();
	}
	
	@PostMapping
	public void addBook(@RequestBody Book book) {
		service.addBook(book);
	}
	
	@GetMapping("/{id}")
	public Book getById(@PathVariable int id) {
		return service.getBookById(id);	}
}
