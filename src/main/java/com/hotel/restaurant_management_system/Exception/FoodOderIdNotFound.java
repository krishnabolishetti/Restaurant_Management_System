package com.hotel.restaurant_management_system.Exception;

public class FoodOderIdNotFound extends  RuntimeException {

private String message=" foodOder Id not Found in Db ";
	
	public String  getMessage() {
		return message;
	}
}
