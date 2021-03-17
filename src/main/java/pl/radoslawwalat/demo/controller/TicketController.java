package pl.radoslawwalat.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radoslawwalat.demo.model.Ticket;
import pl.radoslawwalat.demo.repository.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TicketController {

    private TicketRepository ticketRepository;
    private PriorityRepository priorityRepository;
    private TypeRepository typeRepository;
    private ProjectRepository projectRepository;
    private StatusRepository statusRepository;

    public TicketController(TicketRepository ticketRepository, PriorityRepository priorityRepository, TypeRepository typeRepository, ProjectRepository projectRepository, StatusRepository statusRepository) {
        this.ticketRepository = ticketRepository;
        this.priorityRepository = priorityRepository;
        this.typeRepository = typeRepository;
        this.projectRepository = projectRepository;
        this.statusRepository = statusRepository;
    }


    @GetMapping("/tickets")
    private String listTickets(Model model){
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets";
    }

    @GetMapping("/tickets/add")
    private String addTicket(Model model){

        model.addAttribute("priorities", priorityRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("statuses", statusRepository.findAll());
        model.addAttribute("ticket", new Ticket());
        return "ticketform";
    }
    @PostMapping("/tickets/add")
    private String performAddTicket(Ticket ticket){

        ticket.setCreated(LocalDateTime.now());
        ticketRepository.save(ticket);

        return "redirect:/tickets";
    }

    @GetMapping("/tickets/details/{id}")
    private String showTicketDetails(@PathVariable long id, Model model){

        model.addAttribute("ticket", ticketRepository.findById(id).get());
        return "ticketDetails";
    }

    @GetMapping("/tickets/delete/{id}")
    private String deleteTicket(@PathVariable long id){
        ticketRepository.deleteById(id);
        return "redirect:/tickets";
    }

}
