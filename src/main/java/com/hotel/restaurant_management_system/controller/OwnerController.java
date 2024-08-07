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

import com.hotel.restaurant_management_system.dto.Owner;
import com.hotel.restaurant_management_system.dto.Restaurant;
import com.hotel.restaurant_management_system.services.OwnerServices;
import com.hotel.restaurant_management_system.util.ResponseStructure;
import com.hotel.restaurant_management_system.util.ResponseStructureList;
@RestController
public class OwnerController {

	@Autowired
	OwnerServices ownerServices;
	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner ) {
		return ownerServices.saveOwner(owner);
	}
	
	@GetMapping("/fetchownerById")
	public ResponseEntity<ResponseStructure<Owner>>  fetchownerById(@RequestParam int ownerId) {
		return  ownerServices.fetchownerById(ownerId);
	}
	@DeleteMapping("/deleteById")
	public ResponseEntity<ResponseStructure<Owner>> deleteownerById(@RequestParam int ownerId) {
		return ownerServices.deleteownerById(ownerId);
	}
	@PutMapping("/updateowner")
	public ResponseEntity<ResponseStructure<Owner>>  updateowner(@RequestParam int oldownerId,@RequestBody Owner newowner) {
		return ownerServices.updateowner(oldownerId, newowner);
	}
	@GetMapping("/fetchAllowner")
	public ResponseEntity<ResponseStructureList<Owner>>  fetchAllowner() {
		return ownerServices.fetchAllowner();
		
	}
	@PutMapping("/addExistingRestaurantToexistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToexistingOwner(@RequestParam int ownerId,@RequestParam int restaurantId) {
		return ownerServices.addExistingRestaurantToexistingOwner(ownerId, restaurantId);
	}
	@PutMapping("/addNewRestaurantToexistingOwner")
	public ResponseEntity<ResponseStructure<Owner>>  addNewRestaurantToexistingOwner (@RequestParam int ownerId, @RequestBody Restaurant newrestaurant) {
		return ownerServices.addNewRestaurantToexistingOwner(ownerId, newrestaurant);
	}
}
