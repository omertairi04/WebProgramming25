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

        books.add(new Book("Tko pjeva zlo ne misli", "Comedy/Drama", 8.5));
        books.add(new Book("Underground", "War/Drama", 9.2));
        books.add(new Book("Ko to tamo peva", "Comedy", 8.8));
        books.add(new Book("Before the Rain (Pred doždot)", "Drama", 9.0));
        books.add(new Book("Time of the Gypsies (Dom za vešanje)", "Drama/Fantasy", 8.7));
        books.add(new Book("No Man’s Land (Ničija zemlja)", "War/Drama", 9.1));
        books.add(new Book("The Parade (Parada)", "Comedy/Drama", 8.3));
        books.add(new Book("A Serbian Film", "Horror/Thriller", 6.0));
        books.add(new Book("Bal-Can-Can", "Dark Comedy", 8.0));
        books.add(new Book("Shok", "War/Short Drama", 8.6));
    }
}
