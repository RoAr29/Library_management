package com.library.management.repository;

import org.springframework.stereotype.Repository;
import com.library.management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
