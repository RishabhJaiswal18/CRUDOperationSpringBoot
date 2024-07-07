package com.employee.EmployeeCRUDDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeCRUDDemo.model.Employee;
import com.employee.EmployeeCRUDDemo.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping(value = "/test")
	public String getHelloWorld() {
		return "Hii!! Hello World";
	}

	@GetMapping(value = "/records/{id}")
	public ResponseEntity<Employee> getRecordsById(@PathVariable("id") long id) {
		try {
			Employee emp = empService.getEmployeeRecordsById(id);

			if (emp != null) {
				return new ResponseEntity<>(emp, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/all-records")
	public ResponseEntity<List<Employee>> getAllEmployeeRecords() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			list = empService.getAllEmployeeRecords();

			if (!list.isEmpty()) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/add-employee")
	public ResponseEntity<Employee> addEmployeeRecords(@RequestBody Employee emp) {
		try {
//			System.out.println(emp.toString());
			Employee addedEmployee = empService.addEmployeeRecords(emp);

			if (addedEmployee != null) {
				return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/update-records/{id}")
	public ResponseEntity<Employee> updateEmployeeRecords(@PathVariable("id") long id, @RequestBody Employee emp) {
		try {
			Employee isEmpExist = empService.getEmployeeRecordsById(id);
			if (isEmpExist != null) {
				Employee updateRecords = empService.updateEmployeeRecords(id, emp);

				if (updateRecords != null) {
					return new ResponseEntity<>(updateRecords, HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
