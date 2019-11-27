package com.consulting.company.connectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.consulting.company.entities.Employee;

public interface EmployeeConnector {

    public Employee createEmployee(Employee employee) throws JsonProcessingException;
}
