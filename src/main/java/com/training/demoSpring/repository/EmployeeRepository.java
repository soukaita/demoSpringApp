package com.training.demoSpring.repository;

import com.training.demoSpring.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.cin=:cin")
    Employee findByCin(@Param("cin") String cin);
}
