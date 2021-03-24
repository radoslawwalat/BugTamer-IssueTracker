package pl.radoslawwalat.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    @Size(min=1, max=50)
    private String description;

    private String photo;

    @ManyToOne
    private Admin submitter;

    @ManyToOne
    private Admin assigned;

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

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany(mappedBy = "historyticket", cascade = CascadeType.REMOVE)
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
