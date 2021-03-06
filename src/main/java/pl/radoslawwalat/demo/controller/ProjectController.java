package pl.radoslawwalat.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radoslawwalat.demo.model.Project;
import pl.radoslawwalat.demo.repository.ProjectRepository;

import javax.validation.Valid;
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

        return "projects/projects";
    }

    @GetMapping("/projects/add")
    public String addProject(Model model){
        model.addAttribute("project", new Project());
        return "projects/projectform";
    }

    @PostMapping("/projects/add")
    public String performAddProject(@Valid @ModelAttribute("project")Project project, BindingResult result){
        if (result.hasErrors()) {
            return "projects/projectform";
        }
        projectRepository.save(project);
        return "projects/projects";
    }

    @GetMapping("/projects/details/{id}")
    public String projectDetails(@PathVariable long id, Model model) {

        model.addAttribute("project", projectRepository.findById(id).get());
        model.addAttribute("projects", projectRepository.findAll());


        return "projects/projectDetails";
    }

    @GetMapping("/projects/delete/{id}")
    private String deleteProject(@PathVariable long id){
        projectRepository.deleteById(id);
        return "projects/projects";
    }
}
