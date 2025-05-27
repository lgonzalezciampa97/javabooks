package com.challenge.resourceserver.repository;

import com.challenge.resourceserver.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private final Map<Long, Book> books = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public Book save(Book book) {
        Long id = counter.getAndIncrement();
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    public void deleteById(Long id) {
        books.remove(id);
    }

    public Optional<Book> findByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public List<Book> findByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
}
