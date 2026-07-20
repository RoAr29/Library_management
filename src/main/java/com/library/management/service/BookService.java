package com.library.management.service;

import java.util.*;

import com.library.management.exception.BookNotFoundException;
import com.library.management.model.Book;
import com.library.management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(int id) {
    	return repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
    }

    public Book updateBook(int id, Book updatedBook) {

        Book existingBook = repository.findById(id).orElse(null);

        if (existingBook == null) {
            return null;
        }

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());

        return repository.save(existingBook);
    }

    public void deleteBook(int id) {
        repository.deleteById(id);
    }
}