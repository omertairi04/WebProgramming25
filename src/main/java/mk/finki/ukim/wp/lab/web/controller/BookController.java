package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.service.AuthorService;
import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<Book> books = bookService.listAll();
        model.addAttribute("books", books);
        return "listBooks";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBook(id);

        model.addAttribute("book", book);

        return "viewBook";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title,
                          @RequestParam String genre,
                          @RequestParam Double averageRating,
                          @RequestParam Long authorId) {

        Author author = authorService.findById(authorId);
        Book book = new Book(title, genre, averageRating, author);
        bookService.addBook(book);

        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String getEditBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "editBook";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Book book) {
        bookService.updateBook(id, book);

        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteBook(@PathVariable Long id, Model model) {
        bookService.deleteBook(id);

        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);

        return "redirect:/books";
    }
}
