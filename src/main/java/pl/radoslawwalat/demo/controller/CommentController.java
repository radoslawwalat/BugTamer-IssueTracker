package pl.radoslawwalat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radoslawwalat.demo.model.Comment;
import pl.radoslawwalat.demo.repository.CommentRepository;
import pl.radoslawwalat.demo.repository.TicketRepository;

import java.time.LocalDateTime;

@Controller
public class CommentController {

    private CommentRepository commentRepository;
    private TicketRepository ticketRepository;


    public CommentController(CommentRepository commentRepository, TicketRepository ticketRepository) {
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping("/addcomment/{commentId}")
    public String addComment(@PathVariable long commentId, Comment comment){

        comment.setTicket(ticketRepository.findById(commentId).get());
        // TODO set ticket commenter
        comment.setCreated(LocalDateTime.now());

        // pamietaj zeby zmienna z pathvariable nie nadpisywała jakiegos atrybutu modelu jak sie tak samo nazywa
        commentRepository.save(comment);

        return "redirect:/tickets/details/" + commentId;
    }



}
