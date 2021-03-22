package pl.radoslawwalat.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radoslawwalat.demo.model.Comment;
import pl.radoslawwalat.demo.model.History;
import pl.radoslawwalat.demo.model.Priority;
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
    private HistoryRepository historyRepository;

    public TicketController(TicketRepository ticketRepository, PriorityRepository priorityRepository, TypeRepository typeRepository, ProjectRepository projectRepository, StatusRepository statusRepository, HistoryRepository historyRepository) {
        this.ticketRepository = ticketRepository;
        this.priorityRepository = priorityRepository;
        this.typeRepository = typeRepository;
        this.projectRepository = projectRepository;
        this.statusRepository = statusRepository;
        this.historyRepository = historyRepository;
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

    private void updateHistory(Ticket ticket){
        Ticket ticketOld = ticketRepository.findById(ticket.getId()).get();

        if (!ticketOld.getTitle().equals(ticket.getTitle())) {
            History hist = new History();
            hist.setProperty("Name changed");
            hist.setOldvalue(ticketOld.getTitle());
            hist.setNewvalue(ticket.getTitle());
            hist.setDate(LocalDateTime.now());
            // TODO SET ADMIN HERE
//            hist.setAdmin();
            hist.setHistoryticket(ticket);
            historyRepository.save(hist);
        }
        if (!ticketOld.getDescription().equals(ticket.getDescription())) {
            History histDesc = new History();
            histDesc.setProperty("Description changed");
            histDesc.setOldvalue(ticketOld.getDescription());
            histDesc.setNewvalue(ticket.getDescription());
            histDesc.setDate(LocalDateTime.now());
            // TODO SET ADMIN HERE
//            hist.setAdmin();
            histDesc.setHistoryticket(ticket);
            historyRepository.save(histDesc);
        }
        if (!ticketOld.getPriority().getId().equals(ticket.getPriority().getId())) {
            History histPrio = new History();
            histPrio.setProperty("Priority changed");
            histPrio.setOldvalue(ticketOld.getPriority().getName());
            histPrio.setNewvalue(priorityRepository.findById(ticket.getPriority().getId()).get().getName());
            histPrio.setDate(LocalDateTime.now());
            // TODO SET ADMIN HERE
//            hist.setAdmin();
            histPrio.setHistoryticket(ticket);
            historyRepository.save(histPrio);
        }
        if (!ticketOld.getType().getId().equals(ticket.getType().getId())) {
            History histType = new History();
            histType.setProperty("Type changed");
            histType.setOldvalue(ticketOld.getType().getName());
            histType.setNewvalue(typeRepository.findById(ticket.getType().getId()).get().getName());
            histType.setDate(LocalDateTime.now());
            // TODO SET ADMIN HERE
//            hist.setAdmin();
            histType.setHistoryticket(ticket);
            historyRepository.save(histType);
        }
        if (!ticketOld.getProject().getId().equals(ticket.getProject().getId())) {
            History histProj = new History();
            histProj.setProperty("Project changed");
            histProj.setOldvalue(ticketOld.getProject().getName());
            histProj.setNewvalue(projectRepository.findById(ticket.getProject().getId()).get().getName());
            histProj.setDate(LocalDateTime.now());
            // TODO SET ADMIN HERE
//            hist.setAdmin();
            histProj.setHistoryticket(ticket);
            historyRepository.save(histProj);
        }
        if (!ticketOld.getStatus().getId().equals(ticket.getStatus().getId())) {
            History histStatus = new History();
            histStatus.setProperty("Status changed");
            histStatus.setOldvalue(ticketOld.getStatus().getName());
            histStatus.setNewvalue(statusRepository.findById(ticket.getStatus().getId()).get().getName());
            histStatus.setDate(LocalDateTime.now());
            // TODO SET ADMIN HERE
//            hist.setAdmin();
            histStatus.setHistoryticket(ticket);
            historyRepository.save(histStatus);
        }



    }

    @PostMapping("/tickets/add")
    private String updateTicket(Ticket ticket){

        if (ticket.getCreated() == null) {
            ticket.setCreated(LocalDateTime.now());
        }
        updateHistory(ticket);
        ticketRepository.save(ticket);

        return "redirect:/tickets";
    }

    @GetMapping("/tickets/details/{id}")
    private String showTicketDetails(@PathVariable long id, Model model){

        model.addAttribute("comment", new Comment());
        model.addAttribute("ticket", ticketRepository.findById(id).get());
        return "ticketDetails";
    }

    @GetMapping("/tickets/delete/{id}")
    private String deleteTicket(@PathVariable long id){
        ticketRepository.deleteById(id);
        return "redirect:/tickets";
    }

    @GetMapping("/tickets/edit/{id}")
    public String editTicket(@PathVariable long id, Model model) {

        model.addAttribute("priorities", priorityRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("statuses", statusRepository.findAll());
        model.addAttribute("ticket", ticketRepository.findById(id).get());
        return "ticketEdit";
    }



}
