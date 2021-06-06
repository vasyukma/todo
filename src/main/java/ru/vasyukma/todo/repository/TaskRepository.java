package ru.vasyukma.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vasyukma.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
