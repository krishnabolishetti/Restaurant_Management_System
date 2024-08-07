package com.hotel.restaurant_management_system.Exception;

public class CustomerIdNotFound extends RuntimeException {

private String message=" Customer Id not Found in Db ";
	
	public String  getMessage() {
		return message;
	}
}
