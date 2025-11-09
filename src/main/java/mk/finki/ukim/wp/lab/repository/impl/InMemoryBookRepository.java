package mk.finki.ukim.wp.lab.repository.impl;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream().filter(b -> b.getTitle().toLowerCase().contains(text.toLowerCase()) && b.getAverageRating() >= rating).toList();
    }

    @Override
    public void addBook(Book book) {
        DataHolder.books.add(book);
    }

    @Override
    public Book getBook(long id) {
        return DataHolder.books.stream()
                .filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateBook(long id, Book book) {
        Book toUpdate = getBook(id);
        if (toUpdate != null) {
            toUpdate.setTitle(book.getTitle());
            toUpdate.setAverageRating(book.getAverageRating());
            toUpdate.setGenre(book.getGenre());
            toUpdate.setAuthor(book.getAuthor());
        }
    }

    @Override
    public void deleteBook(long id) {
        DataHolder.books.removeIf(book -> book.getId() == id);
    }


}
