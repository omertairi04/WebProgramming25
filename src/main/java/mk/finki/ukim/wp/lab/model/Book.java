package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Book {
    private String title;
    private String genre;
    private Double averageRating;

    public Book(String title, String genre, Double averageRating) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Double getAverageRating() {
        return averageRating;
    }
}
