package com.hotel.restaurant_management_system.Exception;

public class EmployeeIdNotFound extends RuntimeException {

private String message=" Employee Id not Found in Db ";
	
	public String  getMessage() {
		return message;
	}
}
