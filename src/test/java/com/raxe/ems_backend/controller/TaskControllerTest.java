package com.raxe.ems_backend.controller;

import com.raxe.ems_backend.entity.Task;
import com.raxe.ems_backend.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;
import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task();
        task.setId(1);
        task.setTitle("Title 1");
        task.setDescription("Desc 1");
        task.setStatus(true);
        LocalDate localDate = LocalDate.of(2024, 11, 10);
        task.setStart_date(Date.valueOf(localDate));
    }

    @Test
    public void getTask_ShouldReturnTask_WhenTaskExists() throws Exception {
        // Arrange
        when(taskService.getTaskById(1)).thenReturn(task);

        // Act & Assert
        mockMvc.perform(get("/api/tasks/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(task.getId()));
    }

    @Test
    public void getTask_ShouldReturn404_WhenTaskNotFound() throws Exception {
        // Arrange
        when(taskService.getTaskById(40)).thenReturn(null);

        // Act & Assert
        mockMvc.perform(get("/api/tasks/40").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
