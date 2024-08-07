package com.hotel.restaurant_management_system.Exception;

public class BranchIdNotFound extends RuntimeException {

private String message=" Branch Id not Found in Db ";
	
	public String  getMessage() {
		return message;
	}
}
