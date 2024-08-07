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

import com.hotel.restaurant_management_system.dto.FoodOder;
import com.hotel.restaurant_management_system.services.FoodOderServices;

@RestController
public class FoodOderController {
	
    @Autowired
	FoodOderServices foodOderServices;
    
    @PostMapping("/saveFoodOder")
	public FoodOder saveFoodOder(@RequestBody FoodOder foodOder) {
		return foodOderServices.saveFoodOder(foodOder);
	}
	@GetMapping("/fetchFoodOderById")
	public FoodOder  fetchFoodOderById(@RequestParam int foodOderId) {
		return  foodOderServices.fetchFoodOderById(foodOderId);
	}
	@DeleteMapping("/deleteFoodOderById")
	public FoodOder deleteFoodOderById(@RequestParam int foodOderId) {
		
		return foodOderServices.deleteFoodOderById(foodOderId);
	
	}
	@PutMapping("/updateFoodOder")
	public FoodOder  updateFoodOder(@RequestParam int oldFoodOderId,@RequestBody  FoodOder newfoodOder) {
		
		return foodOderServices.updateFoodOder(oldFoodOderId,newfoodOder);
	}
	@GetMapping("/fetchAllFoodOder")
	public List<FoodOder>  fetchAllFoodOder() {
		return foodOderServices.fetchAllFoodOder();
		
	}
}
