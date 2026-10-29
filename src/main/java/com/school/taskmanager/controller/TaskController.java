package com.school.taskmanager.controller;

import com.school.taskmanager.dto.TaskDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @PostMapping
    public String cadastrar(@RequestBody TaskDTO taskDTO) {
        return "Recebido: " + taskDTO.getNome() + " - " + taskDTO.getEmail();
    }

    @GetMapping
    public String teste() {
        return "Controller funcionando!";
    }
}
