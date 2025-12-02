package mk.finki.ukim.wp.lab.repository.jpa;

import mk.finki.ukim.wp.lab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public List<Author> findAll();
    public Author findById(long id);
    public Author create(Author author);
    public Author editAuthor(long id, Author author);
    public void delete(long id);
}
