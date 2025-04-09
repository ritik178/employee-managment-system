package org.example.ems.Controller;


import org.example.ems.EmployeeManagementApplication;
import org.example.ems.entity.Employee;
import org.example.ems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    private ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PostMapping("/add/bulk")
    private ResponseEntity<List<Employee>> addBulk(@RequestBody List<Employee> employees){
        List<Employee> result = new ArrayList<>();
        for(Employee e : employees){
            result.add(employeeService.save(e));
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<?> getEmployee(@PathVariable Long id){
       Employee e = employeeService.getEmployeeById(id);
       if(e!=null){
           return ResponseEntity.ok(e);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with given id!");
    }

    @GetMapping("/getall")
    private ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    
    @PutMapping("/update/{id}")
    private ResponseEntity<?> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        Employee e = employeeService.updateEmployee(id,employee);
        if(e!=null){
            return ResponseEntity.ok(e);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with given id!");
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }


    @GetMapping("/filter")
    public List<Employee> getEmployeesBySalary(@RequestParam double minSalary) {
        return employeeService.getEmployeesBySalary(minSalary);
    }

}
