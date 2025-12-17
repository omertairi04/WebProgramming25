package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.jpa.BookRepository;
import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        if (text == null || text.isEmpty() || rating == null || rating.isNaN()) {
            throw new IllegalArgumentException();
        }
        return bookRepository.searchBooks(text, rating);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(long id, Book book) {
        Book existing = bookRepository.findById(id).orElseThrow();
        existing.setTitle(book.getTitle());
        existing.setAverageRating(book.getAverageRating());
        existing.setAuthor(book.getAuthor());
        bookRepository.save(existing);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }
}
