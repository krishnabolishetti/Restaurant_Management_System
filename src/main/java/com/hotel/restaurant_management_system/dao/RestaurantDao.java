package com.hotel.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dto.Branch;
import com.hotel.restaurant_management_system.dto.Restaurant;
import com.hotel.restaurant_management_system.repo.RestaurantRepo;

@Repository
public class RestaurantDao {

	@Autowired
	BranchDao branchDao;
	
	@Autowired
    RestaurantRepo restaurantRepo;
	public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}
	public Restaurant  fetchRestaurantById(@RequestParam int restaurantId) {
		Optional<Restaurant> restauran=  restaurantRepo.findById(restaurantId);
		if(restauran.isPresent()) {
			return restauran.get();
		}else {
			return null;
		}
	}
	
	public Restaurant deleteRestaurantById(@RequestParam int restaurantId) {
		Restaurant restaurant=fetchRestaurantById(restaurantId);
		restaurantRepo.delete(restaurant);
		return restaurant;
	}
	
	public Restaurant  updateRestaurant(@RequestParam int oldrestaurantId,@RequestBody  Restaurant newrestaurant) {
		newrestaurant.setRestauranId(oldrestaurantId);;
		return restaurantRepo.save(newrestaurant);
	}
	public List<Restaurant>  fetchAllRestaurant() {
		return restaurantRepo.findAll();
		
	}
	public Restaurant AddExistingAllBranchToExistingRestaurant(int restaurantId) {
		Restaurant restaurant=fetchRestaurantById(restaurantId);
		List<Branch> branchs=branchDao.fetchAllbranch();
		restaurant.setBranchs(branchs);
		return  saveRestaurant(restaurant);
	
	}
	public Restaurant AddExistingBranchtoExistingRestaurant(int restaurantId ,int branchId) {
		Restaurant restaurant=fetchRestaurantById(restaurantId);
		Branch branchs=branchDao.fetchbranchById(branchId);
		List<Branch> branchs2=restaurant.getBranchs();
		branchs2.add(branchs);
		restaurant.setBranchs(branchs2);
		return saveRestaurant(restaurant) ;
	}
	public Restaurant AddNewBranchToExistingRestaurant(int restaurantId,Branch newbranch) {
	     Restaurant restaurant=fetchRestaurantById(restaurantId);
	     List<Branch> branchs=restaurant.getBranchs();
	     branchs.add(newbranch);
		restaurant.setBranchs(branchs);
		return saveRestaurant(restaurant) ;
		
	}
}





