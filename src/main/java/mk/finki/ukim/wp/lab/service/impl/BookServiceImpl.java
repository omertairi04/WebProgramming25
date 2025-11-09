package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.BookRepository;
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
        return bookRepository.getBook(id);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    @Override
    public void updateBook(long id, Book book) {
        bookRepository.updateBook(id, book);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

}
