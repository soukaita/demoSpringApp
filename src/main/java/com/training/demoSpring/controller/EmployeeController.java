package com.training.demoSpring.controller;

import com.training.demoSpring.model.Employee;
import com.training.demoSpring.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Employee")

public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    //Inject the service into controller by setter
    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{cin}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Employee getEmployeeByCin(@PathVariable String cin) {
        logger.info("Find Employee : {}", cin);
        return employeeService.getEmployeeByCin(cin);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Employee createEmployee(@RequestBody Employee employee) {
        logger.info("Creating Employee : {}", employee);
        return employeeService.createEmployee(employee);
    }

}
