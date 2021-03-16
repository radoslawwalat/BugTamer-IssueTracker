package pl.radoslawwalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.radoslawwalat.demo.model.Priority;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

}
