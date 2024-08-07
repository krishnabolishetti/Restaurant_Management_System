package com.hotel.restaurant_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.restaurant_management_system.dto.Customer;
import com.hotel.restaurant_management_system.dto.FoodOder;
import com.hotel.restaurant_management_system.services.CustomerServices;
import com.hotel.restaurant_management_system.util.ResponseStructure;
import com.hotel.restaurant_management_system.util.ResponseStructureList;

@RestController
public class CustomerController {

	@Autowired
	CustomerServices customerServices;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerServices.saveCustomer(customer);
	}
	@GetMapping("/fetchCustomerById")
	public ResponseEntity<ResponseStructure<Customer>>  fetchCustomerById(@RequestParam int customerId) {
		return  customerServices.fetchCustomerById(customerId);
	}
	@DeleteMapping("/deleteCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int customerId) {
		
		return customerServices.deleteCustomerById(customerId);
	
	}
	@PutMapping("/updateCustomer")
	public ResponseEntity<ResponseStructure<Customer>>  updateCustomer(@RequestParam int oldcustomerId,@RequestBody  Customer newcustomer) {
		
		return customerServices.updateCustomer(oldcustomerId,newcustomer);
	}
	@GetMapping("/fetchAllCustomer")
	public ResponseEntity<ResponseStructureList<Customer>>  fetchAllCustomer() {
		return customerServices.fetchAllCustomer();
		
	}
	@PutMapping("/addExistingfoodToExistingcustomer")
	public ResponseEntity<ResponseStructure<Customer>> addExistingfoodToExistingcustomer (@RequestParam int customerId,@RequestParam int foododerId) {
		return customerServices.addExistingfoodToExistingcustomer(customerId, foododerId);
		
	}
     @PutMapping("/addNewfoodToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewfoodToExistingCustomer (@RequestParam int customerId,@RequestBody FoodOder newfoododer ) {
		return customerServices.addNewfoodToExistingCustomer(customerId, newfoododer);
	}
	
}
