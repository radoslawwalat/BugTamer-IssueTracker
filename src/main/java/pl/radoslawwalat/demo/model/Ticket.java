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

    private String photo;

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

    @OneToMany(mappedBy = "historyticket")
    private List<History> histories;

    public String getCreatedFormat() {

        if (created == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = created.format(formatter);
        return formatDateTime;
    }
    public String getUpdatedFormat() {

        if (updated == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = updated.format(formatter);
        return formatDateTime;
    }
}
