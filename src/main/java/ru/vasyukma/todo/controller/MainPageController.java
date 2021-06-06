package ru.vasyukma.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.vasyukma.todo.model.Task;
import ru.vasyukma.todo.service.TaskService;

@Controller
public class MainPageController {
    
    @Autowired
    private TaskService taskService;
    
    @GetMapping("/main")
    public String main(Authentication a, Model model) {
        model.addAttribute("username", a.getName());
//        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", taskService.findAll());
//        model.addAttribute("tasks", tasks);
        
        return "main.html";
//        return "test.html";
    }
}
