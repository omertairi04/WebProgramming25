package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.repository.jpa.AuthorRepository;
import mk.finki.ukim.wp.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author editAuthor(long id, Author author) {
        Author existing = authorRepository.findById(id).orElseThrow();

        existing.setName(author.getName());
        existing.setSurname(author.getSurname());
        existing.setCountry(author.getCountry());
        existing.setBiography(author.getBiography());

        return authorRepository.save(existing);
    }

    @Override
    public void delete(long id) {
        authorRepository.deleteById(id);
    }
}
