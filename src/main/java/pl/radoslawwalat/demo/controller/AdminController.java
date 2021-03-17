package pl.radoslawwalat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radoslawwalat.demo.model.Admin;
import pl.radoslawwalat.demo.model.Role;
import pl.radoslawwalat.demo.repository.AdminRepository;
import pl.radoslawwalat.demo.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    private AdminRepository adminRepository;
    private RoleRepository roleRepository;

    public AdminController(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;

        this.roleRepository = roleRepository;
    }

    @ModelAttribute("roles")
    public List<Role> roles(){
        return roleRepository.findAll();
    }

    @GetMapping("/roles")
    public String roles(Model model){

        model.addAttribute("admins", adminRepository.findAll());
        model.addAttribute("admin", new Admin());

        return "roles";
    }
    @PostMapping("/roles")
    public String rolesAdd(Admin admin){

        Admin adminToSave = adminRepository.findById(admin.getId()).get();
        adminToSave.setRole(admin.getRole());
        adminRepository.save(adminToSave);

        return "redirect:/roles";
    }
}
