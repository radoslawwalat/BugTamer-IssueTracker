package pl.radoslawwalat.demo.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="admins")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, unique = true)
    @Size(min = 3, max = 60, message = "Size between 3 and 60")
    @NotBlank(message = "Name is mandatory")
    private String username;

    @Email
    private String email;

    @NotBlank(message = "password is mandatory")
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
