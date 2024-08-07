package com.hotel.restaurant_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.restaurant_management_system.dto.Employee;
import com.hotel.restaurant_management_system.services.EmployeeServices;
@RestController
public class EmployeeController {

	@Autowired
	EmployeeServices employeeServices;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeServices.saveEmployee(employee);
	}
	@GetMapping("/fetchEmployeeById")
	public Employee  fetchEmployeeById(@RequestParam int employeeId) {
		return  employeeServices.fetchEmployeeById(employeeId);
	}
	@DeleteMapping("/deleteEmployeeById")
	public Employee deleteEmployeeById(@RequestParam int employeeId) {
		
		return employeeServices.deleteEmployeeById(employeeId);
	
	}
	@PutMapping("/updateEmployee")
	public Employee  updateEmployee(@RequestParam int oldemployeeId,@RequestBody  Employee newemployee) {
		
		return employeeServices.updateEmployee(oldemployeeId,newemployee);
	}
	@GetMapping("/fetchAllEmployee")
	public List<Employee>  fetchAllEmployee() {
		return employeeServices.fetchAllEmployee();
		
	}
}
