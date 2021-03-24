package pl.radoslawwalat.demo.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radoslawwalat.demo.model.Comment;
import pl.radoslawwalat.demo.model.History;
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
    private AdminRepository adminRepository;


    public TicketController(TicketRepository ticketRepository, PriorityRepository priorityRepository, TypeRepository typeRepository, ProjectRepository projectRepository, StatusRepository statusRepository, HistoryRepository historyRepository, AdminRepository adminRepository) {
        this.ticketRepository = ticketRepository;
        this.priorityRepository = priorityRepository;
        this.typeRepository = typeRepository;
        this.projectRepository = projectRepository;
        this.statusRepository = statusRepository;
        this.historyRepository = historyRepository;
        this.adminRepository = adminRepository;
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

    private void updateHistory(Ticket ticket ,UserDetails customUser){
        Ticket ticketOld = ticketRepository.findById(ticket.getId()).get();
        boolean updated = false;

        if (!ticketOld.getTitle().equals(ticket.getTitle())) {
            History hist = new History();
            hist.setProperty("Name changed");
            hist.setOldvalue(ticketOld.getTitle());
            hist.setNewvalue(ticket.getTitle());
            hist.setDate(LocalDateTime.now());
            hist.setAdmin(adminRepository.findByUsername(customUser.getUsername()));
            hist.setHistoryticket(ticket);
            historyRepository.save(hist);
            updated = true;
        }
        if (!ticketOld.getDescription().equals(ticket.getDescription())) {
            History histDesc = new History();
            histDesc.setProperty("Description changed");
            histDesc.setOldvalue(ticketOld.getDescription());
            histDesc.setNewvalue(ticket.getDescription());
            histDesc.setDate(LocalDateTime.now());
            histDesc.setAdmin(adminRepository.findByUsername(customUser.getUsername()));
            histDesc.setHistoryticket(ticket);
            historyRepository.save(histDesc);
            updated = true;
        }
        if (!ticketOld.getPriority().getId().equals(ticket.getPriority().getId())) {
            History histPrio = new History();
            histPrio.setProperty("Priority changed");
            histPrio.setOldvalue(ticketOld.getPriority().getName());
            histPrio.setNewvalue(priorityRepository.findById(ticket.getPriority().getId()).get().getName());
            histPrio.setDate(LocalDateTime.now());
            histPrio.setAdmin(adminRepository.findByUsername(customUser.getUsername()));
            histPrio.setHistoryticket(ticket);
            historyRepository.save(histPrio);
            updated = true;
        }
        if (!ticketOld.getType().getId().equals(ticket.getType().getId())) {
            History histType = new History();
            histType.setProperty("Type changed");
            histType.setOldvalue(ticketOld.getType().getName());
            histType.setNewvalue(typeRepository.findById(ticket.getType().getId()).get().getName());
            histType.setDate(LocalDateTime.now());
            histType.setAdmin(adminRepository.findByUsername(customUser.getUsername()));
            histType.setHistoryticket(ticket);
            historyRepository.save(histType);
            updated = true;
        }
        if (!ticketOld.getProject().getId().equals(ticket.getProject().getId())) {
            History histProj = new History();
            histProj.setProperty("Project changed");
            histProj.setOldvalue(ticketOld.getProject().getName());
            histProj.setNewvalue(projectRepository.findById(ticket.getProject().getId()).get().getName());
            histProj.setDate(LocalDateTime.now());
            histProj.setAdmin(adminRepository.findByUsername(customUser.getUsername()));
            histProj.setHistoryticket(ticket);
            historyRepository.save(histProj);
            updated = true;
        }
        if (!ticketOld.getStatus().getId().equals(ticket.getStatus().getId())) {
            History histStatus = new History();
            histStatus.setProperty("Status changed");
            histStatus.setOldvalue(ticketOld.getStatus().getName());
            histStatus.setNewvalue(statusRepository.findById(ticket.getStatus().getId()).get().getName());
            histStatus.setDate(LocalDateTime.now());
            histStatus.setAdmin(adminRepository.findByUsername(customUser.getUsername()));
            histStatus.setHistoryticket(ticket);
            historyRepository.save(histStatus);
            updated = true;
        }

        if (updated) {
            ticket.setUpdated(LocalDateTime.now());
        }

    }
    @PostMapping("/tickets/update")
    private String updateExistingTicket(@AuthenticationPrincipal UserDetails customUser, Ticket ticket){


            updateHistory(ticket, customUser);
            ticket.setUpdated(LocalDateTime.now());

        ticketRepository.save(ticket);

        return "redirect:/tickets";
    }
    @GetMapping("/tickets/pickup/{ticketid}")
    private String assignLoggedToTicket(@AuthenticationPrincipal UserDetails customUser, @PathVariable long ticketid){

        Ticket ticket = ticketRepository.findById(ticketid).get();
        ticket.setAssigned(adminRepository.findByUsername(customUser.getUsername()));

        ticketRepository.save(ticket);

        return "redirect:/tickets/details/" + ticketid;
    }

    @PostMapping("/tickets/add")
    private String updateTicket(@AuthenticationPrincipal UserDetails customUser, Ticket ticket){


        ticket.setCreated(LocalDateTime.now());
        ticket.setSubmitter(adminRepository.findByUsername(customUser.getUsername()));

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
