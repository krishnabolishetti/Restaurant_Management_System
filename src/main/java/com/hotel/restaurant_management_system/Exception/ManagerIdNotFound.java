package com.hotel.restaurant_management_system.Exception;

public class ManagerIdNotFound extends RuntimeException {

private String message=" Manager Id not Found in Db ";
	
	public String  getMessage() {
		return message;
	}
}
