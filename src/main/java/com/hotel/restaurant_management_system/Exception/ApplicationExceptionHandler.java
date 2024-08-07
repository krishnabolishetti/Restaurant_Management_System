package com.hotel.restaurant_management_system.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.restaurant_management_system.dto.Address;
import com.hotel.restaurant_management_system.dto.Branch;
import com.hotel.restaurant_management_system.dto.Customer;
import com.hotel.restaurant_management_system.dto.Employee;
import com.hotel.restaurant_management_system.dto.FoodOder;
import com.hotel.restaurant_management_system.dto.Manager;
import com.hotel.restaurant_management_system.dto.Menu;
import com.hotel.restaurant_management_system.dto.Owner;
import com.hotel.restaurant_management_system.dto.Restaurant;
import com.hotel.restaurant_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponseStructure<Owner>> OwnerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		ResponseStructure<Owner> responseStructure=new ResponseStructure<Owner>();
		responseStructure.setMessage("Owner id not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RestaurantIdNotFound.class)
	public ResponseEntity<ResponseStructure<Restaurant>> restauranIdNotFound(RestaurantIdNotFound restaurantIdNotFound) {
		ResponseStructure<Restaurant> responseStructure=new ResponseStructure<Restaurant>();
		responseStructure.setMessage("restaurant id not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<Address>> AddressIdNotFound(AddressIdNotFound AddressIdNotFound) {
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setMessage("Owner id not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<Branch>> BranchIdNotFound(BranchIdNotFound BranchIdNotFound) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setMessage("Owner id not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponseStructure<Customer>> CustomerIdNotFound(CustomerIdNotFound CustomerIdNotFound) {
		ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
		responseStructure.setMessage("Owner id not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponseStructure<Employee>> EmployeeIdNotFound(EmployeeIdNotFound EmployeeIdNotFound) {
		ResponseStructure<Employee> responseStructure=new ResponseStructure<Employee>();
		responseStructure.setMessage("Owner id not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FoodOderIdNotFound.class)
	public ResponseEntity<ResponseStructure<FoodOder>> FoodOderIdNotFound(FoodOderIdNotFound FoodOderIdNotFound) {
		ResponseStructure<FoodOder> responseStructure=new ResponseStructure<FoodOder>();
		responseStructure.setMessage("Owner id not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<FoodOder>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseEntity<ResponseStructure<Manager>> ManagerIdNotFound(ManagerIdNotFound ManagerIdNotFound) {
		ResponseStructure<Manager> responseStructure=new ResponseStructure<Manager>();
		responseStructure.setMessage("Owner id not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MenuIdNotFound.class)
	public ResponseEntity<ResponseStructure<Menu>> MenuIdNotFound(MenuIdNotFound MenuIdNotFound) {
		ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>();
		responseStructure.setMessage("Owner id not found ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
}







