package com.hotel.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dto.FoodOder;
import com.hotel.restaurant_management_system.repo.FoodOderRepo;

@Repository
public class FoodOderDao {

	@Autowired
	FoodOderRepo foodOderRepo;
	
	public FoodOder saveFoodOder(@RequestBody FoodOder foodOder) {
		return foodOderRepo.save(foodOder);
	}
	public FoodOder  fetchFoodOderById(@RequestParam int foodOderId) {
		Optional<FoodOder> foododer=foodOderRepo.findById(foodOderId);
		if(foododer.isPresent()) {
			return foododer.get();
		}else {
			return null;
		}
	
	}
	
	public FoodOder deleteFoodOderById(@RequestParam int foodOderId) {
		FoodOder foodOder=fetchFoodOderById(foodOderId);
		foodOderRepo.delete(foodOder);
		return foodOder;
	}
	
	public FoodOder  updateFoodOder(@RequestParam int oldfoodOderId,@RequestBody  FoodOder newfoodOder) {
		newfoodOder.setFoodorderId(oldfoodOderId);;
		return foodOderRepo.save(newfoodOder);
	}
	public List<FoodOder>  fetchAllFoodOder() {
		return foodOderRepo.findAll();
		
	}
}
