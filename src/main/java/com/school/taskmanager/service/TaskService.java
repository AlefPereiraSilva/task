package com.school.taskmanager.service;

import com.school.taskmanager.model.Task;
import com.school.taskmanager.repository.TaskRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Task> listarTodos() {
        return taskRepository.findAll();
    }

    public Task buscarPorId(Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa/Utilizador não encontrado com o ID: " + id));
    }

    public Task salvar(Task task) {
        String senhaCriptografada = passwordEncoder.encode(task.getSenha());
        task.setSenha(senhaCriptografada);

        return taskRepository.save(task);
    }

    public Task atualizar(Long id, Task taskAtualizada) {
        Task taskExistente = buscarPorId(id);

        taskExistente.setNome(taskAtualizada.getNome());
        taskExistente.setEmail(taskAtualizada.getEmail());
        taskExistente.setTelefone(taskAtualizada.getTelefone());
        taskExistente.setDataNascimento(taskAtualizada.getDataNascimento());

        if(taskAtualizada.getSenha() != null && !taskAtualizada.getSenha().isEmpty()) {
        taskExistente.setSenha(passwordEncoder.encode(taskAtualizada.getSenha()));
        }

        return taskRepository.save(taskExistente);
    }

    public void deletar(Long id) {
        Task task = buscarPorId(id);
        taskRepository.delete(task);
    }
}
