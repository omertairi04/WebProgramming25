package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Book {
    private static long counter = 0;
    private long id;
    private String title;
    private String genre;
    private Double averageRating;
    private Author author;

    public Book(String title, String genre, Double averageRating, Author author) {
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
