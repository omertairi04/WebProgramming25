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
}
