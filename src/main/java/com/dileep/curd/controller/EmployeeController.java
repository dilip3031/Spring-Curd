package com.dileep.curd.controller;

import com.dileep.curd.entity.EmployeeEntity;
import com.dileep.curd.services.EmployeeService;
import com.dileep.curd.utils.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeEntity> save(@RequestBody EmployeeEntity employeeEntity) throws GeneralException {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employeeEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> findEmployeeById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> findAllEmployee() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAllEmployee());
    }

    @PutMapping
    public ResponseEntity<EmployeeEntity> update(@RequestBody EmployeeEntity employeeEntity) throws GeneralException {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(employeeEntity));
    }

}
