package com.raxe.ems_backend.repository;

import com.raxe.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(
        readOnly = true
)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
