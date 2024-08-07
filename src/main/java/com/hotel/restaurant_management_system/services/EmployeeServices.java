package com.hotel.restaurant_management_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dao.EmployeeDao;
import com.hotel.restaurant_management_system.dto.Employee;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeDao employeeDao;
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeDao.saveEmployee(employee);
	}
	public Employee  fetchEmployeeById(@RequestParam int employeeId) {
		return  employeeDao.fetchEmployeeById(employeeId);
	}
	
	public Employee deleteEmployeeById(@RequestParam int employeeId) {
		
		return employeeDao.deleteEmployeeById(employeeId);
	
	}
	
	public Employee  updateEmployee(@RequestParam int oldemployeeId,@RequestBody  Employee newemployee) {
		
		return employeeDao.updateEmployee(oldemployeeId,newemployee);
	}
	public List<Employee>  fetchAllEmployee() {
		return employeeDao.fetchAllEmployee();
		
	}
}
