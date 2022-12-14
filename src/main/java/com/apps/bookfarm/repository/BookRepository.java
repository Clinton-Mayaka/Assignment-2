package com.apps.bookfarm.repository;

import com.apps.bookfarm.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>{

    List<Book> findBookById(long id);
    Optional<Book> findByTitle(String title);

}
