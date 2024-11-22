package com.raxe.ems_backend.service.impl;

import com.raxe.ems_backend.dto.EmployeeDto;
import com.raxe.ems_backend.entity.Employee;
import com.raxe.ems_backend.exception.ResourceNotFoundException;
import com.raxe.ems_backend.mapper.EmployeeMapper;
import com.raxe.ems_backend.repository.EmployeeRepository;
import com.raxe.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("employeeServiceImpl")
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =  employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        System.out.println(employees.toString());
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());
        Employee updateEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updateEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

        employeeRepository.deleteById(employeeId);
    }
}
