package pl.radoslawwalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.radoslawwalat.demo.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
