package pl.radoslawwalat.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.radoslawwalat.demo.model.Admin;
import pl.radoslawwalat.demo.model.Project;
import pl.radoslawwalat.demo.model.Role;
import pl.radoslawwalat.demo.repository.AdminRepository;
import pl.radoslawwalat.demo.repository.ProjectRepository;
import pl.radoslawwalat.demo.repository.RoleRepository;
import pl.radoslawwalat.demo.service.AdminService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class AdminController {

    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    private ProjectRepository projectRepository;
    private AdminService adminService;


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
        List<Project> projects = adminToSave.getProjects();
        projects.addAll(admin.getProjects());

        List<Project> deduped = projects.stream().distinct().collect(Collectors.toList());
        adminToSave.setProjects(deduped);

        adminRepository.save(adminToSave);

        return "redirect:/projects";

    }

    @GetMapping("/signup")
    public String createAdmin(Model model){
        model.addAttribute("admin", new Admin());
        return "adminForm";
    }
    @PostMapping("/signup")
    public String performCreateAdmin(Admin admin){
        adminService.saveAdmin(admin);
        return "redirect:/login";
    }

    // SECURITY TEST

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("admin");
        adminService.saveAdmin(admin);
        return "admin";
    }

}
