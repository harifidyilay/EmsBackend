package com.raxe.ems_backend.service.impl;

import com.raxe.ems_backend.dto.TaskDto;
import com.raxe.ems_backend.entity.Employee;
import com.raxe.ems_backend.entity.Task;
import com.raxe.ems_backend.exception.ResourceNotFoundException;
import com.raxe.ems_backend.mapper.EmployeeMapper;
import com.raxe.ems_backend.mapper.TaskMapper;
import com.raxe.ems_backend.repository.TaskRepository;
import com.raxe.ems_backend.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("taskServiceImpl")
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public Task getTaskById(Integer taskId) {
        Optional<Task> task = taskRepository.findTaskById(taskId);
        return task.orElseThrow(()->new ResourceNotFoundException("Task is not exists with given id : " + taskId));
    }

}
