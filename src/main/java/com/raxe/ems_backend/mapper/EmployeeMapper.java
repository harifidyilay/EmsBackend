package com.raxe.ems_backend.mapper;

import com.raxe.ems_backend.dto.EmployeeDto;
import com.raxe.ems_backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
      return new EmployeeDto(
              employee.getId(),
              employee.getFirstName(),
              employee.getLastName(),
              employee.getEmail(),
              employee.getTasks()
      );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getTasks()
        );
    }


}
