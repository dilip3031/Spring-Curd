package com.dileep.curd.services;

import com.dileep.curd.entity.EmployeeEntity;
import com.dileep.curd.repositorys.EmployeesRepository;
import com.dileep.curd.utils.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService extends RootService {
    private final EmployeesRepository employeesRepository;

    public EmployeeEntity save(EmployeeEntity employeeEntity) throws GeneralException {
        return (EmployeeEntity) checkSaveAndUpdateRequest(employeeEntity, employeesRepository);
    }

    public EmployeeEntity findEmployeeById(Long id) {
        return employeesRepository.findById(id).orElse(new EmployeeEntity());
    }

    public List<EmployeeEntity> findAllEmployee() {
        return employeesRepository.findAll();
    }

    public EmployeeEntity update(EmployeeEntity employeeEntity) throws GeneralException {
        return (EmployeeEntity) checkSaveAndUpdateRequest(employeeEntity, employeesRepository);
    }
}
