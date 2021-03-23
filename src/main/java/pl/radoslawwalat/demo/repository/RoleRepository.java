package pl.radoslawwalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.radoslawwalat.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
