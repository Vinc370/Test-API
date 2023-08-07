package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.Services.EmployeeService;

@SpringBootTest
class Gdp24ApplicationTests {
	@Autowired
	private EmployeeService<Employee> employeeServiceTest;

	@Test
	public void Insert() {
		Boolean expected = true;

		Employee employee = new Employee();
		Department department =  new Department(2001, null, null);
		employee.setEmployeeID(1003);
		employee.setFullName("Daniel Brown");
		employee.setDepartment(department);

		Boolean result = employeeServiceTest.Insert(employee);

		assertEquals(expected, result);
	}

}
