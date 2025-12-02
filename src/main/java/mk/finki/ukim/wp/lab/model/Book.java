package mk.finki.ukim.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Optional;

@Entity
@Data
@Table(name="books")
public class Book {
    private static long counter = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column()
    private String title;
    @Column()
    private String genre;
    @Column()
    private Double averageRating;
    @ManyToOne
    private Author author;

    public Book(String title, String genre, Double averageRating, Optional<Author> author) {
        this.id = counter++;
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
