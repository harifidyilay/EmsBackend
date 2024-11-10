package com.raxe.ems_backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.raxe.ems_backend.entity.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Integer id;
    private String title;
    private String description;
    private boolean status;
    private Date start_date;
    private Employee employee;
}
