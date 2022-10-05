package com.apps.bookfarm.service;

import com.apps.bookfarm.model.Book;

public interface BookService {
    public Iterable<Book> getBooks();
    public void addBook(Book book);
    public void addBook(Book... book);
    public void updateBook(Book book);
    public void removeBook(Book book);
}
