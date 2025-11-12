package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public String getAuthors(@RequestParam (required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "listAuthors";
    }

    @PostMapping("/add")
    public String addAuthor(@RequestParam String name,
                            @RequestParam String surname,
                            @RequestParam String country,
                            @RequestParam String biography){
        Author author = new Author(name, surname, country, biography);

        Author a = authorService.create(author);

        return "redirect:/author";
    }

    @GetMapping("/{id}")
    public String getAuthor (@PathVariable long id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "viewAuthor";
    }

    @GetMapping("/edit/{id}")
    public String getEditAuthor(@PathVariable Long id, Model model) {
        Author a = authorService.findById(id);
        System.out.println("A : " + a);
        model.addAttribute("author",a);
        return "editAuthor";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@PathVariable Long id, Author author) {
        authorService.editAuthor(id, author);
        return "redirect:/author";

    }

    @GetMapping("/delete/{id}")
    public String getDeleteAuthor(@PathVariable Long id, Model model) {
        authorService.delete(id);
        return "redirect:/author";

    }

    @PostMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:/author";

    }
}
