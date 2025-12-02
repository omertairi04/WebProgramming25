package mk.finki.ukim.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="authors")
public class Author {
    private static long counter = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String name;
    @Column()
    private String surname;
    @Column()
    private String country;
    @Column(length=400)
    private String biography;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(String name, String surname, String country, String biography) {
        this.id = counter++;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
        this.books = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getFullName() {
        return name + " " + surname;
    }


}
