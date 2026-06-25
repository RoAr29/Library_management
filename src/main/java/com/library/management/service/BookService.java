package com.library.management.service;

import java.util.*;
import com.library.management.model.Book;
import com.library.management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;
    
    public void addBook(Book book) {
    	repository.addBook(book);
    }
    
    public List<Book> getAllBooks(){
    	return repository.getAllBooks();
    }
    
    public Book getBookById(int id) {
    	
    	List<Book> books = repository.getAllBooks();
    	
    	for(Book book:books) {
    		if(book.getId() == id) {
    			return book;
    		}
    	}
    	return null;
    }

}