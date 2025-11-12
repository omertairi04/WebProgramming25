package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> findAll();
    public Author findById(Long id);
    public Author create(Author author);
    public Author editAuthor(long id, Author author);
    public void delete(long id);
}
