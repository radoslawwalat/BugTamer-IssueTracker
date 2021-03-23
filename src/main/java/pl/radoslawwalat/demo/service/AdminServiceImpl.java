package pl.radoslawwalat.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.radoslawwalat.demo.model.Admin;
import pl.radoslawwalat.demo.model.Role;
import pl.radoslawwalat.demo.repository.AdminRepository;
import pl.radoslawwalat.demo.repository.RoleRepository;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public Admin findByAdminName(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public void saveAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        // TODO ENABLED (skipped)

        // TODO hardcoded role_user?
        Role userRole = roleRepository.findByName("ROLE_USER");
        // TODO wiele ról? (idk) HashSet<> polecany
        admin.setRole(userRole);
        adminRepository.save(admin);
    }
}
