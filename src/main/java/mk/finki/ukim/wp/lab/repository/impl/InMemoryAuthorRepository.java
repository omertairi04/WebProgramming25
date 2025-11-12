package mk.finki.ukim.wp.lab.repository.impl;


import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryAuthorRepository implements AuthorRepository {

    @Override
    public List<Author> findAll() {
        return DataHolder.authors;
    }

    @Override
    public Author findById(long id) {
        return DataHolder.authors.stream().filter(author -> author.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Author create(Author author) {
        DataHolder.authors.add(author);
        return author;
    }

    @Override
    public Author editAuthor(long id, Author author) {
        Author toEdit = findById(id);
        if (toEdit != null) {
            toEdit.setName(author.getName());
            toEdit.setSurname(author.getSurname());
            toEdit.setBiography(author.getBiography());
            toEdit.setCountry(author.getCountry());
        }

        return toEdit;
    }

    @Override
    public void delete(long id) {
        DataHolder.authors.removeIf(a -> a.getId() == id);
    }
}
