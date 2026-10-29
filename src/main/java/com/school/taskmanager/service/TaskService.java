package com.school.taskmanager.service;

import com.school.taskmanager.model.Task;
import com.school.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listarTodos() {
        return taskRepository.findAll();
    }

    public Task salvar(Task task) {
        return taskRepository.save(task);
    }

    public Task buscarPorId(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        taskRepository.deleteById(id);
    }
}
