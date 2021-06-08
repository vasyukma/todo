package ru.vasyukma.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.vasyukma.todo.model.Job;
import ru.vasyukma.todo.repository.BoxRepository;
import ru.vasyukma.todo.repository.JobRepository;
import ru.vasyukma.todo.service.TaskService;

@Controller
public class MainPageController {
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private BoxRepository boxRepository;
    
    @GetMapping("/main")
    public String main(Authentication a, Model model) {
        
        List<Job> jobs = jobRepository.findAll();
        
        model.addAttribute("username", a.getName());
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("boxes", boxRepository.findAll());
        
        return "main.html";
    }
}
