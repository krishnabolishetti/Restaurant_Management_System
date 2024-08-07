package com.hotel.restaurant_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.restaurant_management_system.dto.Branch;
import com.hotel.restaurant_management_system.dto.Restaurant;
import com.hotel.restaurant_management_system.services.RestaurantServices;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantServices restaurantServices;
	
	@PostMapping("/saveRestaurant")
	public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantServices.saveRestaurant(restaurant);
	}
	@GetMapping("/fetchRestaurantById")
	public Restaurant  fetchRestaurantById(@RequestParam int restaurantId) {
		return  restaurantServices.fetchRestaurantById(restaurantId);
	}
	@DeleteMapping("/deleteRestaurantById")
	public Restaurant deleteRestaurantById(@RequestParam int restaurantId) {
		
		return restaurantServices.deleteRestaurantById(restaurantId);
	
	}
	@PutMapping("/updateRestaurant")
	public Restaurant  updateRestaurant(@RequestParam int oldrestaurantId,@RequestBody  Restaurant newrestaurant) {
		
		return restaurantServices.updateRestaurant(oldrestaurantId,newrestaurant);
	}
	@GetMapping("/fetchAllRestaurant")
	public List<Restaurant>  fetchAllRestaurant() {
		return restaurantServices.fetchAllRestaurant();
		
	}
	@PutMapping("/AddExistingAllBranchToExistingRestaurant")
	public Restaurant AddExistingAllBranchToExistingRestaurant(@RequestParam int restaurantId) {
		return  restaurantServices.AddExistingAllBranchToExistingRestaurant(restaurantId);
	}
	@PutMapping("/AddExistingBranchtoExistingRestaurant")
	public Restaurant AddExistingBranchtoExistingRestaurant (@RequestParam int restaurantId ,@RequestParam int branchId) {
		return restaurantServices.AddExistingBranchtoExistingRestaurant(restaurantId, branchId);
	}
	@PutMapping("/AddNewBranchToExistingRestaurant")
	public Restaurant AddNewBranchToExistingRestaurant(@RequestParam int restaurantId,@RequestBody Branch newbranch) {
		return restaurantServices.AddNewBranchToExistingRestaurant(restaurantId, newbranch);
	}
	
}
