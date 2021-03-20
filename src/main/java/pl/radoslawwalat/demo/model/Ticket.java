package pl.radoslawwalat.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    private Admin submitter;

    @ManyToOne
    private Project project;  // nazwa projektu

    @ManyToOne
    private Priority priority; // low medium high

    @ManyToOne
    private Status status; // in progress, need information itd. ODDZIELNA TABELA
    // ostatni z tabeli osobnej statusów danego ticketu do przemyślenia

    @ManyToOne
    private Type type; // buggs, fixes, frontend, backend itd.

    private LocalDateTime created;
    private LocalDateTime updated;

    @OneToMany(mappedBy = "ticket")
    private List<Comment> comments;

    public LocalDateTime getCreated() {
        return created;
    }
}
