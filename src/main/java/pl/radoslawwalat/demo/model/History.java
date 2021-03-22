package pl.radoslawwalat.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String property;
    private String oldvalue;
    private String newvalue;
    private LocalDateTime date;

    @ManyToOne
    private Admin admin;

    @ManyToOne
    private Ticket historyticket;

}
