package ru.vasyukma.todo.model.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Authority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    @JoinColumn(name =  "authUser")
    @ManyToOne
    private AuthUser authUser;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AuthUser getAuthUser() {
        return authUser;
    }
    
    
}
