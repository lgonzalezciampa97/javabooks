package com.challenge.resourceserver.controller;

import com.challenge.resourceserver.model.Book;
import com.challenge.resourceserver.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(service.addBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        return service.findByTitle(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(service.findByAuthor(author));
    }

    @GetMapping("/test")
    public String test() {
        return "Test Hi";
    }
}
