package com.pradip.keycloakdemo.controller;

import com.pradip.keycloakdemo.model.Employee;
import com.pradip.keycloakdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int employeeId){

            return ResponseEntity.ok(employeeRepository.findById(employeeId));

    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int employeeId){
        try{
            employeeRepository.deleteById(employeeId);
            return ResponseEntity.ok("User deleted successfully.");
        }
        catch (Exception e){
            return ResponseEntity.ok("User is not available with id "+employeeId+" .");
        }
    }

    @GetMapping("/public")
    public ResponseEntity<String> getPublicPage(){
        return ResponseEntity.ok("Welcome user.");
    }
}
