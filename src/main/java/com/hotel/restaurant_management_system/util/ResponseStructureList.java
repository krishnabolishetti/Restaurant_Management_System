package com.hotel.restaurant_management_system.util;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructureList<T> {
	
	private String message;
	private int statusCode;
	private List<T> data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	

}
