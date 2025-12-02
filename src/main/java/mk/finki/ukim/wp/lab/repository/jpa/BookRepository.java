package mk.finki.ukim.wp.lab.repository.jpa;

import mk.finki.ukim.wp.lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();

    List<Book> searchBooks(String text, Double rating);

    void addBook(Book book);

    Book getBook(long id);

    void updateBook(long id, Book book);

    void deleteBook(long id);
    List<Book> findAllByAuthor_Id(Long authorId);
}
