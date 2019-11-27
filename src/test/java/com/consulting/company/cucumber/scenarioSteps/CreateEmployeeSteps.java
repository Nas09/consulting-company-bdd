package com.consulting.company.cucumber.scenarioSteps;

import com.consulting.company.connectors.EmployeeConnector;
import com.consulting.company.entities.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateEmployeeSteps {


    @Autowired
    EmployeeConnector employeeConnector;

    private Employee employee;
    private Employee createdEmployee;

    boolean expectedException = false;


    @Before
    public void init() {
        employee = new Employee();

    }


    @Given("new Employee with a FirstName ([^\"]*), Lastname ([^\"]*), Adress ([^\"]*)")
    public void newEmployee(String firstname, String lastname, String adress) {
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.setAdress(adress);
    }

    @When("a user create the new Employee")
    public void createTheNewEmployee() {

        try {
            createdEmployee = employeeConnector.createEmployee(employee);
        } catch (JsonProcessingException e) {
            expectedException = true;
        }

    }

    @Then("the new Employee is created")
    public void employeeIsCreated() throws JsonProcessingException {
        Assert.assertFalse(expectedException);
        Assert.assertEquals(employee.getFirstname(), createdEmployee.getFirstname());
        Assert.assertEquals(employee.getLastname(), createdEmployee.getLastname());
        Assert.assertEquals(employee.getAdress(), createdEmployee.getAdress());
    }

}
