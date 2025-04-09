package org.example.ems.services;


import org.example.ems.entity.Employee;
import org.example.ems.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee save(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Long id,Employee employee){
        Employee e = employeeRepo.findById(id).orElse(null);
        if(e!=null){
            e.setName(employee.getName()==null?e.getName():employee.getName());
            e.setEmail(employee.getEmail()==null?e.getEmail():employee.getEmail());
            e.setSalary(employee.getSalary()==null?e.getSalary():employee.getSalary());
            e.setDepartment(employee.getDepartment()==null?e.getDepartment():employee.getDepartment());
            e.setAddress(employee.getAddress()==null?e.getAddress():employee.getAddress());
            return employeeRepo.save(e);
        }
        return null;

    }

    public ResponseEntity<String> deleteEmployee(Long id){
        Employee e = employeeRepo.findById(id).orElse(null);
        if(e!=null){
            employeeRepo.delete(e);
            return ResponseEntity.ok("Employee deleted successfully!");
        }
        return ResponseEntity.ok("Employee not found with given id!");
    }

    public List<Employee> getEmployeesBySalary(double minSalary) {
        return employeeRepo.findBySalaryGreaterThanEqual(minSalary);
    }
}
