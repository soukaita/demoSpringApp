package com.training.demoSpring.service;

import com.training.demoSpring.model.Employee;
import com.training.demoSpring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //Inject the repo into service by controller
    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeByCin(String cin) {
        return employeeRepository.findByCin(cin);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
