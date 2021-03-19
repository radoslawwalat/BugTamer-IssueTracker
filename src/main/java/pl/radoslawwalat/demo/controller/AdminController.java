package pl.radoslawwalat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radoslawwalat.demo.model.Admin;
import pl.radoslawwalat.demo.model.Role;
import pl.radoslawwalat.demo.repository.AdminRepository;
import pl.radoslawwalat.demo.repository.ProjectRepository;
import pl.radoslawwalat.demo.repository.RoleRepository;

import java.util.List;

@Controller
public class AdminController {

    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    private ProjectRepository projectRepository;


    public AdminController(AdminRepository adminRepository, RoleRepository roleRepository, ProjectRepository projectRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
        this.projectRepository = projectRepository;
    }

    @ModelAttribute("roles")
    public List<Role> roles(){
        return roleRepository.findAll();
    }

    @GetMapping("/manage/roles")
    public String roles(Model model){

        model.addAttribute("admins", adminRepository.findAll());
        model.addAttribute("admin", new Admin());

        return "roles";
    }
    @PostMapping("/manage/roles")
    public String rolesAdd(Admin admin){

        Admin adminToSave = adminRepository.findById(admin.getId()).get();
        adminToSave.setRole(admin.getRole());
        adminRepository.save(adminToSave);

        return "redirect:/manage/roles";
    }

    @GetMapping("/manage/projects")
    public String assignProjects(Model model){

        model.addAttribute("admin", new Admin());
        model.addAttribute("admins", adminRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());

        return "assignProject";

    }
    @PostMapping("/manage/projects")
    public String assignProjectsUpdate(Admin admin){

        Admin adminToSave = adminRepository.findById(admin.getId()).get();
        adminToSave.setProjects(admin.getProjects());
        adminRepository.save(adminToSave);

        return "redirect:/projects";

    }
}
