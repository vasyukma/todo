package ru.vasyukma.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String topic;
    private String description;
    public Integer getId() {
        return id;
    }
    public String getTopic() {
        return topic;
    }
    public String getDescription() {
        return description;
    }
    
    
}
