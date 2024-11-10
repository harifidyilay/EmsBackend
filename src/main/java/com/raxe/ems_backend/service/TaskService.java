package com.raxe.ems_backend.service;

import com.raxe.ems_backend.dto.EmployeeDto;
import com.raxe.ems_backend.dto.TaskDto;
import com.raxe.ems_backend.entity.Task;

public interface TaskService {

    Task getTaskById(Integer taskId);
}
