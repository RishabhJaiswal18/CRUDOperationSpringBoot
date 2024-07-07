package com.employee.EmployeeCRUDDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeCRUDDemo.model.Employee;
import com.employee.EmployeeCRUDDemo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public Employee addEmployeeRecords(Employee emp) {
		try {
			// Save the employee, which will return the saved entity with the generated ID
			Employee savedEmployee = empRepository.save(emp);
			return savedEmployee;
		} catch (Exception e) {
			e.printStackTrace();
			// Return null or throw an exception if addition fails
			return null;
		}
	}

	public List<Employee> getAllEmployeeRecords() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			list = empRepository.findAll();
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public Employee getEmployeeRecordsById(long id) {
		try {
			Employee emp = empRepository.findById(id).get();
			if (emp != null) {
				return emp;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public Employee updateEmployeeRecords(long id, Employee emp) {
		try {
			int updatedRecords = empRepository.updateEmployeeRecords(id, emp.getFirstName(), emp.getLastName(),
					emp.getDesignation(), emp.getSalary(), emp.getAddress());
			if (updatedRecords == 1) {
				return empRepository.findById(id).get();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
