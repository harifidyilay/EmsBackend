package com.raxe.ems_backend.controller;

import com.raxe.ems_backend.dto.EmployeeDto;
import com.raxe.ems_backend.dto.TaskDto;
import com.raxe.ems_backend.entity.Task;
import com.raxe.ems_backend.service.EmployeeService;
import com.raxe.ems_backend.service.TaskService;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // If one implementation only : we can remove @Qualifier
    @Autowired
    public TaskController(@Qualifier("taskServiceImpl") TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Integer taskId) {
        Task task = taskService.getTaskById(taskId);
        if (task == null) {
            return ResponseEntity.notFound().build(); // Return 404 if task not found
        }
        return ResponseEntity.ok(task);
    }
}
