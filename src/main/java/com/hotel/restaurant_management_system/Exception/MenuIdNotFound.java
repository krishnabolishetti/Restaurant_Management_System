package com.hotel.restaurant_management_system.Exception;

public class MenuIdNotFound extends RuntimeException {

private String message=" Menu Id not Found in Db ";
	
	public String  getMessage() {
		return message;
	}
}
