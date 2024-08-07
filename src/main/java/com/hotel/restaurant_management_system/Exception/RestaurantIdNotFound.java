package com.hotel.restaurant_management_system.Exception;

public class RestaurantIdNotFound  extends RuntimeException{

private String message=" Restaurant Id not Found in Db ";
	
	public String  getMessage() {
		return message;
	}
}
