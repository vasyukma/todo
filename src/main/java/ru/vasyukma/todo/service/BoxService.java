package ru.vasyukma.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.vasyukma.todo.model.Box;
import ru.vasyukma.todo.repository.BoxRepository;

@Service
public class BoxService {
    
    @Autowired
    private BoxRepository boxRepository;
    
    public List<Box> findAll() {
        return boxRepository.findAll();
    }
}
