package pl.radoslawwalat.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Admin getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Admin submitter) {
        this.submitter = submitter;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
