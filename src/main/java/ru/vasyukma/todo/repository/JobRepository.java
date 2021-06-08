package ru.vasyukma.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vasyukma.todo.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
