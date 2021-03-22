package pl.radoslawwalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.radoslawwalat.demo.model.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
