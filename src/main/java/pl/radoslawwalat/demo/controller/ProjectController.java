package pl.radoslawwalat.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radoslawwalat.demo.model.Project;
import pl.radoslawwalat.demo.repository.ProjectRepository;

import java.util.List;

@Controller
public class ProjectController {

    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects")
    public String listProjects(Model model){
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        return "projects";
    }

    @GetMapping("/projects/add")
    public String addProject(Model model){
        model.addAttribute("project", new Project());
        return "projectform";
    }

    @PostMapping("/projects/add")
    public String performAddProject(Project project){
        projectRepository.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/projects/details/{id}")
    public String projectDetails(@PathVariable long id, Model model) {

        model.addAttribute("project", projectRepository.findById(id).get());
        model.addAttribute("projects", projectRepository.findAll());


        return "projectDetails";
    }
}
