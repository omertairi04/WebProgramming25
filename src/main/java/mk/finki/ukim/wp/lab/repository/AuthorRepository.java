package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AuthorRepository {
    public List<Author> findAll();
    public Author findById(long id);
    public Author create(Author author);
    public Author editAuthor(long id, Author author);
    public void delete(long id);
}
