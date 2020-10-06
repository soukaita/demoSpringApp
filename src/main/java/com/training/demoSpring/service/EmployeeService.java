package com.training.demoSpring.service;

import com.training.demoSpring.model.Employee;

public interface EmployeeService {

    Employee getEmployeeByCin(final String cin);
    Employee createEmployee(Employee employee);

}
