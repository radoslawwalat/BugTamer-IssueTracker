package pl.radoslawwalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.radoslawwalat.demo.model.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Long> {
}
