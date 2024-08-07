package com.hotel.restaurant_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.restaurant_management_system.dto.Address;
import com.hotel.restaurant_management_system.services.AddressServices;
import com.hotel.restaurant_management_system.util.ResponseStructure;
import com.hotel.restaurant_management_system.util.ResponseStructureList;

@RestController
public class AddressController {

	@Autowired
	AddressServices addressServices;
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressServices.saveAddress(address);
	}
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>>  fetchAddressById(@RequestParam int addressId) {
		return  addressServices.fetchAddressById(addressId);
	}
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {
		
		return addressServices.deleteAddressById(addressId);
	
	}
	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>>  updateAddress(@RequestParam int oldaddressId,@RequestBody  Address newaddress) {
		
		return addressServices.updateAddress(oldaddressId,newaddress);
	}
	@GetMapping("/fetchAllAddress")
	public ResponseEntity<ResponseStructureList<Address>>  fetchAllAddress() {
		return addressServices.fetchAllAddress();
		
	}
	
}
