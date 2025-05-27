package com.challenge.resourceserver.service;

import com.challenge.resourceserver.model.Book;
import com.challenge.resourceserver.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    public Optional<Book> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    public List<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }
}
