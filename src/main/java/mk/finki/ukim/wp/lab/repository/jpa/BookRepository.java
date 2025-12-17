package mk.finki.ukim.wp.lab.repository.jpa;

import mk.finki.ukim.wp.lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(
            "select b from Book b " +
                    "where lower(b.title) like lower(concat('%', :text, '%')) " +
                    "and b.averageRating >= :rating"
    )
    List<Book> searchBooks(@Param("text") String text,
                           @Param("rating") Double rating);

    List<Book> findAllByAuthor_Id(Long authorId);
}
