package ru.vasyukma.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ru.vasyukma.todo.service.TaskService;

@Controller
public class MainPageController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/main")
    public String main(Authentication a, Model model) {
        generateModel(a, model);
        return "main.html";
    }
    
    @PostMapping("/main")
    public String addTask(Authentication a, Model model, String subject) {
        taskService.addTask(subject);
        generateModel(a, model);
        return "main.html";
    }
    
    @DeleteMapping("/main")
    public String deleteTask(Authentication a, Model model, Integer taskId) {
        taskService.deleteTask(taskId);
        generateModel(a, model);
        return "main.html";
    }
    
    public Model generateModel(Authentication a, Model model) {
        model.addAttribute("username", a.getName());
        model.addAttribute("tasks", taskService.findAll());
        return model;
    }
}
