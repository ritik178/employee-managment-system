package org.example.ems.repo;

import org.example.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByEmail(String email);
    List<Employee> findBySalaryGreaterThanEqual(double salary);

}
