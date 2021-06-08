package ru.vasyukma.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vasyukma.todo.model.Box;

public interface BoxRepository extends JpaRepository<Box, Integer> {
}
