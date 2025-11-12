package mk.finki.ukim.wp.lab.model;

public class Author {
    private static long counter = 0;
    private Long id;
    private String name;
    private String surname;
    private String country;
    private String biography;

    public Author(String name, String surname, String country, String biography) {
        this.id = counter++;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
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
