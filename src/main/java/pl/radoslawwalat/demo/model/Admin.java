package pl.radoslawwalat.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="admins")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String email;
    private String password;

    @ManyToOne
    private Role role;

    @ManyToMany
    private List<Project> projects;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
