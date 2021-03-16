package pl.radoslawwalat.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @OneToMany
    private List<Project> projects;



}
