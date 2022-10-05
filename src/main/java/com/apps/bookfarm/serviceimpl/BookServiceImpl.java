package com.apps.bookfarm.serviceimpl;

import com.apps.bookfarm.model.Book;
import com.apps.bookfarm.repository.BookRepository;
import com.apps.bookfarm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Book> getBooks() {
        return repository.findAll();
    }

    @Override
    public void addBook(Book book) {
        Optional<Book> optionalBook = repository.findByTitle(book.getTitle());
        if(optionalBook.isPresent()){
            throw new IllegalStateException("Book with title already exists");
        }else {
            repository.save(book);
        }
    }

    @Override
    public void addBook(Book... book) {
        for(int i = 0; i < book.length; i++){
            repository.save(book[i]);
        }
    }

    @Override
    public void updateBook(Book book) {
        repository.save(book);
    }

    @Override
    public void removeBook(Book book) {
        repository.delete(book);
    }

}
