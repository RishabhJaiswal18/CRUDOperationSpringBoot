package com.employee.EmployeeCRUDDemo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.EmployeeCRUDDemo.model.Employee;
import com.employee.EmployeeCRUDDemo.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService empService;

	@Mock
	private EmployeeRepository empRepository;

	@Test
	public void addEmployeeRecordSuccessfully() {
		Employee emp = new Employee(5L, "AAA", "BBB", "CA", "Delhi", 500.0);
	}
}
