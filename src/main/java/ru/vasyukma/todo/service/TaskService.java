package ru.vasyukma.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.vasyukma.todo.model.Task;
import ru.vasyukma.todo.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    
    public void addTask(String subject) {
        taskRepository.save(new Task(subject));
    }
    
    public void deleteTask(int taskId) {
        taskRepository.delete(taskRepository.getById(taskId));
    }
}
