package com.employee.EmployeeCRUDDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeCRUDDemo.model.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	@Modifying
//	@Query(value = "insert into employee_details(first_name,last_name,designation,salary,address)values(:firstName, :lastName, :designation, :salary, :address)", nativeQuery = true)
//	@Transactional
//	int addEmployee(@Param("firstName") String firstName, @Param("lastName") String lastName,
//			@Param("designation") String designation, @Param("salary") Double salary, @Param("address") String address);

	@Modifying
	@Query(value = "update employee_details set first_name=:firstName,last_name=:lastName,designation=:designation,salary=:salary,address=:address where id=:id", nativeQuery = true)
	@Transactional
	int updateEmployeeRecords(@Param("id") long id, @Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("designation") String designation,
			@Param("salary") Double salary, @Param("address") String address);

}
