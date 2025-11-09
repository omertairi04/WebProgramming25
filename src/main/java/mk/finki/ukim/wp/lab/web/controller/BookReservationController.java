package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {


    private final BookReservationService bookReservationService;
    private final SpringTemplateEngine springTemplateEngine;

    public BookReservationController(BookReservationService bookReservationService, SpringTemplateEngine springTemplateEngine) {
        this.bookReservationService = bookReservationService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @GetMapping()
    public String getReservationConfirmation(
            @RequestParam String bookTitle,
            @RequestParam String readerName,
            @RequestParam String ipAddress,
            @RequestParam("numCopies") int numberOfCopies,
            Model model
    ) {
        model.addAttribute("bookTitle", bookTitle);
        model.addAttribute("readerName", readerName);
        model.addAttribute("ipAddress", ipAddress);
        model.addAttribute("numberOfCopies", numberOfCopies);

        return "reservationConfirmation";
    }

    @PostMapping()
    public String bookReservationConfirmation(@RequestParam String bookTitle,
                                              @RequestParam String readerName,
                                              @RequestParam String ipAddress,
                                              @RequestParam("numCopies") int numberOfCopies) {
        bookReservationService.placeReservation(bookTitle, readerName, ipAddress, numberOfCopies);

        return "redirect:/bookReservation";
    }

}
