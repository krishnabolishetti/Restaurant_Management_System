package com.hotel.restaurant_management_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dao.RestaurantDao;
import com.hotel.restaurant_management_system.dto.Branch;
import com.hotel.restaurant_management_system.dto.Restaurant;

@Service
public class RestaurantServices {

	@Autowired
	RestaurantDao restaurantDao;
	public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantDao.saveRestaurant(restaurant);
	}
	public Restaurant  fetchRestaurantById(@RequestParam int restaurantId) {
		return  restaurantDao.fetchRestaurantById(restaurantId);
	}
	
	public Restaurant deleteRestaurantById(@RequestParam int restaurantId) {
		
		return restaurantDao.deleteRestaurantById(restaurantId);
	
	}
	
	public Restaurant  updateRestaurant(@RequestParam int oldrestaurantId,@RequestBody  Restaurant newrestaurant) {
		
		return restaurantDao.updateRestaurant(oldrestaurantId,newrestaurant);
	}
	public List<Restaurant>  fetchAllRestaurant() {
		return restaurantDao.fetchAllRestaurant();
		
	}
	public Restaurant AddExistingAllBranchToExistingRestaurant(int restaurantId) {
		return  restaurantDao.AddExistingAllBranchToExistingRestaurant(restaurantId);
	}
	public Restaurant AddExistingBranchtoExistingRestaurant(int restaurantId ,int branchId) {
		return restaurantDao.AddExistingBranchtoExistingRestaurant(restaurantId, branchId);
	}
	public Restaurant AddNewBranchToExistingRestaurant(int restaurantId,Branch newbranch) {
		return restaurantDao.AddNewBranchToExistingRestaurant(restaurantId, newbranch);
	}

}
