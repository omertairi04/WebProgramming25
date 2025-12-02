package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.service.AuthorService;
import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        model.addAttribute("books", bookService.listAll());
        return "listBooks"; // Thymeleaf template
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);

        return "viewBook";
    }

    @GetMapping("/add")
    public String getAddBookPage(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title,
                          @RequestParam String genre,
                          @RequestParam Double averageRating,
                          @RequestParam Long authorId) {

        Author author = authorService.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Book book = new Book(title, genre, averageRating, Optional.ofNullable(author));
        bookService.addBook(book);

        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String getEditBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBook(id);

        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.findAll());

        return "editBook";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {

        Author author = authorService.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // build updated book object
        Book updated = new Book(title, genre, averageRating, Optional.ofNullable(author));

        bookService.updateBook(id, updated);

        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBookPost(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
