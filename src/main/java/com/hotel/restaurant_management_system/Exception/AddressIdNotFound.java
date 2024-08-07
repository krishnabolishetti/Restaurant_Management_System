package com.hotel.restaurant_management_system.Exception;

public class AddressIdNotFound extends RuntimeException {
	
	private String message=" Address Id not Found in Db ";
	
	public String  getMessage() {
		return message;
	}

}
