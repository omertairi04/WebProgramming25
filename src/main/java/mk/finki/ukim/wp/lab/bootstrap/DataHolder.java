package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;
    public static List<BookReservation> reservations = null;
    public static List<Author> authors = null;

    @PostConstruct
    public void init() {
        books = new ArrayList<>();
        reservations = new ArrayList<>();
        authors = new ArrayList<>();

        // 1. Create authors (American)
        Author a1 = new Author("Mark", "Twain", "USA", "Author of classics known for humor and social commentary.");
        Author a2 = new Author("Ernest", "Hemingway", "USA", "Famous for minimalist writing and war themes.");
        Author a3 = new Author("F. Scott", "Fitzgerald", "USA", "Known for capturing the Jazz Age.");
        Author a4 = new Author("Harper", "Lee", "USA", "Author of one of the most influential novels in American literature.");
        Author a5 = new Author("Stephen", "King", "USA", "Master of horror, supernatural fiction, and suspense.");
        Author a6 = new Author("Toni", "Morrison", "USA", "Nobel Prize-winning novelist.");
        Author a7 = new Author("John", "Steinbeck", "USA", "Known for stories about the Great Depression and human struggle.");

        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        authors.add(a4);
        authors.add(a5);
        authors.add(a6);
        authors.add(a7);

        // 2. Create books (American books) and assign authors
        books.add(new Book("The Adventures of Tom Sawyer", "Fiction/Adventure", 8.5, a1));
        books.add(new Book("The Old Man and the Sea", "Drama", 9.2, a2));
        books.add(new Book("The Great Gatsby", "Fiction/Drama", 9.0, a3));
        books.add(new Book("To Kill a Mockingbird", "Fiction/Drama", 9.5, a4));
        books.add(new Book("The Shining", "Horror/Thriller", 8.7, a5));
        books.add(new Book("Beloved", "Historical Fiction", 9.3, a6));
        books.add(new Book("Of Mice and Men", "Drama", 8.8, a7));
        books.add(new Book("It", "Horror", 8.4, a5));
        books.add(new Book("A Farewell to Arms", "War/Drama", 8.6, a2));
        books.add(new Book("Song of Solomon", "Fiction", 8.9, a6));
    }

}
