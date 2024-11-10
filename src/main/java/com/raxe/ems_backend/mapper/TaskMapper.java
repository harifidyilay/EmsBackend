package com.raxe.ems_backend.mapper;

import com.raxe.ems_backend.dto.EmployeeDto;
import com.raxe.ems_backend.dto.TaskDto;
import com.raxe.ems_backend.entity.Employee;
import com.raxe.ems_backend.entity.Task;

public class TaskMapper {

    public static TaskDto mapToTaskDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isStatus(),
                task.getStart_date(),
                task.getEmployee()
        );
    }

    public static Task mapToTask(TaskDto taskDto) {
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getDescription(),
                taskDto.isStatus(),
                taskDto.getStart_date(),
                taskDto.getEmployee()
        );
    }

}
