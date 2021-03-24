package pl.radoslawwalat.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radoslawwalat.demo.model.Comment;
import pl.radoslawwalat.demo.repository.AdminRepository;
import pl.radoslawwalat.demo.repository.CommentRepository;
import pl.radoslawwalat.demo.repository.TicketRepository;

import java.time.LocalDateTime;

@Controller
public class CommentController {

    private CommentRepository commentRepository;
    private TicketRepository ticketRepository;
    private AdminRepository adminRepository;


    public CommentController(CommentRepository commentRepository, TicketRepository ticketRepository, AdminRepository adminRepository) {
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
        this.adminRepository = adminRepository;
    }

    @PostMapping("/addcomment/{commentId}")
    public String addComment(@AuthenticationPrincipal UserDetails customUser, @PathVariable long commentId, Comment comment){

        comment.setTicket(ticketRepository.findById(commentId).get());
        comment.setCommenter(adminRepository.findByUsername(customUser.getUsername()));
        comment.setCreated(LocalDateTime.now());

        // pamietaj zeby zmienna z pathvariable nie nadpisywała jakiegos atrybutu modelu jak sie tak samo nazywa
        commentRepository.save(comment);

        return "redirect:/tickets/details/" + commentId;
    }



}
