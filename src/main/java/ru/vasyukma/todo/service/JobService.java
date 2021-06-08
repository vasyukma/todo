package ru.vasyukma.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.vasyukma.todo.model.Job;
import ru.vasyukma.todo.repository.JobRepository;

@Service
public class JobService {
    
    @Autowired
    private JobRepository jobRepository;
    
    public List<Job> findAll() {
        return jobRepository.findAll();
    }
}
