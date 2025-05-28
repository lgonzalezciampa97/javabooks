package com.challenge.resourceserver.config;

import com.challenge.resourceserver.model.Book;
import com.challenge.resourceserver.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book(null, "Cien años de soledad", "Gabriel García Márquez", 471, "Realismo mágico", "La historia de la familia Buendía"));
            bookRepository.save(new Book(null, "1984", "George Orwell", 328, "Distopía", "Una sociedad bajo vigilancia totalitaria"));
            bookRepository.save(new Book(null, "El Principito", "Antoine de Saint-Exupéry", 96, "Fábula", "Un pequeño príncipe recorre planetas"));
            bookRepository.save(new Book(null, "Don Quijote de la Mancha", "Miguel de Cervantes", 863, "Novela", "Las aventuras de un hidalgo loco y su escudero"));
            bookRepository.save(new Book(null, "Fahrenheit 451", "Ray Bradbury", 249, "Ciencia ficción", "Un futuro donde los libros están prohibidos"));
            bookRepository.save(new Book(null, "Orgullo y prejuicio", "Jane Austen", 432, "Romance", "Una historia de amor y sociedad en Inglaterra"));
            bookRepository.save(new Book(null, "Crónica de una muerte anunciada", "Gabriel García Márquez", 144, "Novela", "Un asesinato anunciado por todo el pueblo"));
            bookRepository.save(new Book(null, "La Metamorfosis", "Franz Kafka", 201, "Existencialismo", "Un hombre se convierte en insecto"));
            bookRepository.save(new Book(null, "Los juegos del hambre", "Suzanne Collins", 374, "Distopía", "Una lucha por sobrevivir en una arena mortal"));
            bookRepository.save(new Book(null, "Rayuela", "Julio Cortázar", 666, "Narrativa", "Una novela que rompe las reglas de la narrativa tradicional"));
        };
    }
}
