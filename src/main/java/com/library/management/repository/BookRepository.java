package com.library.management.repository;

import com.library.management.model.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	
	private List<Book> books = new ArrayList<>();
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public List<Book> getAllBooks(){
		return books;
	}
	
	
}
