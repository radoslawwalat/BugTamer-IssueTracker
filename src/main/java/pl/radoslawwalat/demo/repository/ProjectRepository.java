package pl.radoslawwalat.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.radoslawwalat.demo.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
