package ru.vasyukma.todo.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
    
    Optional<AuthUser> findAuthUserByUsername(String username);
}
