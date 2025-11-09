package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.impl.InMemoryBookReservationRepository;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    List<Book> searchBooks(String text, Double rating);

    void addBook(Book book);

    Book getBook(long id);

    void updateBook(long id, Book book);

    void deleteBook(long id);
}
