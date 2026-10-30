package com.school.taskmanager.controller;

import com.school.taskmanager.dto.TaskDTO;
import com.school.taskmanager.model.Task;
import com.school.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    public final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> listar() {
        return taskService.listarTodos();
    }

    @GetMapping("/{id}")
    public Task buscarPorId(@PathVariable Long id) {
        return taskService.buscarPorId(id);
    }

    @PostMapping
    public Task cadastrar(@RequestBody TaskDTO taskDTO) {
        Task task = new Task();
        task.setNome(taskDTO.getNome());
        task.setEmail(taskDTO.getEmail());
        task.setTelefone(taskDTO.getTelefone());
        task.setDataNascimento(taskDTO.getDataNascimento());
        task.setSenha(taskDTO.getSenha());

        return taskService.salvar(task);
    }

    @PutMapping("/{id}")
    public Task atualizar(@PathVariable Long id, @REquestBody TaskDTO taskdto) {
        Task task = new Task();
        task.setNome(taskDTO.getNome());
        task.setEmail(taskDTO.getEmail());
        task.setTelefone(taskDTO.getTelefone());
        task.setDataNascimento(taskDTO.getDataNascimento());
        task.setSenha(taskDTO.getSenha());

        return taskService.atualizar(id, task);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        return taskService.deletar(id);
    }

    @GetMapping("/teste")
    public String teste() {
        return "Controller funcionando!";
    }
}
