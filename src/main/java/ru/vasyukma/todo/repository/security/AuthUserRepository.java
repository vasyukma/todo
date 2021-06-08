package ru.vasyukma.todo.repository.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vasyukma.todo.model.security.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
    
    Optional<AuthUser> findAuthUserByUsername(String username);
}
