package pl.radoslawwalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.radoslawwalat.demo.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
