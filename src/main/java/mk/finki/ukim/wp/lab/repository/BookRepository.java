package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.impl.InMemoryBookReservationRepository;
import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
}
