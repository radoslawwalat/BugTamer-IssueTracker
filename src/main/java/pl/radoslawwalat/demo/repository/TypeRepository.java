package pl.radoslawwalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.radoslawwalat.demo.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
