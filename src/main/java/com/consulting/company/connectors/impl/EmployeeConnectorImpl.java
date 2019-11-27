package com.consulting.company.connectors.impl;

import com.consulting.company.connectors.EmployeeConnector;
import com.consulting.company.entities.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeeConnectorImpl implements EmployeeConnector {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Employee createEmployee(Employee employee) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String employeeStr = objectMapper.writeValueAsString(employee);
        HttpEntity<String> request = new HttpEntity<>(employeeStr, headers);

        ResponseEntity<Employee> logedAdvisorEntity = restTemplate.exchange("http://localhost:1112/api/employee", HttpMethod.POST, request, Employee.class);

        return logedAdvisorEntity.getBody();
    }
}
