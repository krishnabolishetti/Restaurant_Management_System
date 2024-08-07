package com.hotel.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dto.Employee;
import com.hotel.restaurant_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}
	public Employee  fetchEmployeeById(@RequestParam int employeeId) {
		Optional<Employee> employee=employeeRepo.findById(employeeId);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			return null;
		}
		
	}
	
	public Employee deleteEmployeeById(@RequestParam int employeeId) {
		Employee employee=fetchEmployeeById(employeeId);
		employeeRepo.delete(employee);
		return employee;
	}
	
	public Employee  updateEmployee(@RequestParam int oldemployeeId,@RequestBody  Employee newemployee) {
		newemployee.setEmployeeId(oldemployeeId);;
		return employeeRepo.save(newemployee);
	}
	public List<Employee>  fetchAllEmployee() {
		return employeeRepo.findAll();
		
	}
}
