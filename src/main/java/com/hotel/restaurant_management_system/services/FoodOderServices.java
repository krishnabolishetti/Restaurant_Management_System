package com.hotel.restaurant_management_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dao.FoodOderDao;
import com.hotel.restaurant_management_system.dto.FoodOder;

@Service
public class FoodOderServices {

	@Autowired
	FoodOderDao foodOderDao;
	public FoodOder saveFoodOder(@RequestBody FoodOder foodOder) {
		return foodOderDao.saveFoodOder(foodOder);
	}
	public FoodOder  fetchFoodOderById(@RequestParam int foodOderId) {
		return  foodOderDao.fetchFoodOderById(foodOderId);
	}
	
	public FoodOder deleteFoodOderById(@RequestParam int foodOderId) {
		
		return foodOderDao.deleteFoodOderById(foodOderId);
	
	}
	
	public FoodOder  updateFoodOder(@RequestParam int oldfoodOderId,@RequestBody  FoodOder newfoodOder) {
		
		return foodOderDao.updateFoodOder(oldfoodOderId,newfoodOder);
	}
	public List<FoodOder>  fetchAllFoodOder() {
		return foodOderDao.fetchAllFoodOder();
		
	}
}
