package com.hotel.restaurant_management_system.Exception;

public class OwnerIdNotFound extends RuntimeException {

private String message=" Owners Id not Found or missig from  Db ";
	
	public String  getMessage() {
		return message;
	}
}
