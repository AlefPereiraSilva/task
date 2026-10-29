package com.school.taskmanager.repository;

import com.school.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByEmail(String email);
}
