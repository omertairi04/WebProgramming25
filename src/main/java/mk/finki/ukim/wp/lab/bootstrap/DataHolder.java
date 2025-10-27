package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;
    public static List<BookReservation> reservations = null;

    @PostConstruct
    public void init(){
        books = new ArrayList<>();
        reservations = new ArrayList<>();

        books.add(new Book("Interstellar", "Sci-Fi", 10.0));
        books.add(new Book("Mad Max", "Action", 8.3));
        books.add(new Book("Top Gun", "Action", 9.9));
        books.add(new Book("Top Gun: Maverick", "Action", 10.0));
        books.add(new Book("The Godfather", "Mafia", 10.0));
        books.add(new Book("Blade Runner 2049", "Sci-Fi", 9.5));
        books.add(new Book("Blade Runner", "Action", 9.3));
        books.add(new Book("Mad Max: Furiosa", "Action", 10.0));
        books.add(new Book("The Godfather 2", "Mafia", 10.0));
    }
}
