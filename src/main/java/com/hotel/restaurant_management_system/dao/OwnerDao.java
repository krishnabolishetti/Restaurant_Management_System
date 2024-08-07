package com.hotel.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dto.Owner;
import com.hotel.restaurant_management_system.dto.Restaurant;
import com.hotel.restaurant_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	RestaurantDao restaurantDao;
	
	@Autowired
	OwnerRepo ownerRepo;
	public Owner saveOwner(@RequestBody Owner owner ) {
		return ownerRepo.save(owner);
	}
	
	public Owner  fetchownerById(@RequestParam int ownerId) {
		Optional<Owner>  owner=ownerRepo.findById(ownerId);
		if(owner.isPresent()) {
			return owner.get();
		}else {
			return null;
		}
		
	}
	
	public Owner deleteownerById(@RequestParam int ownerId) {
		Owner owner=fetchownerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}
	
	public Owner  updateowner(@RequestParam int oldownerId,@RequestBody Owner newowner) {
		newowner.setOwnerId(oldownerId);
		return ownerRepo.save(newowner);
	}
	public List<Owner>  fetchAllowner() {
		return ownerRepo.findAll();
		
	}
	
	public Owner addExistingRestaurantToexistingOwner(int ownerId,int restaurantId) {
		Owner owner=fetchownerById(ownerId);
		Restaurant restaurant=restaurantDao.fetchRestaurantById(restaurantId);
		owner.setRestaurant(restaurant);
		return saveOwner(owner);
	}
	public Owner  addNewRestaurantToexistingOwner (int ownerId,Restaurant newrestaurant) {
		Owner owner=fetchownerById(ownerId);
		owner.setRestaurant(newrestaurant);
		return saveOwner(owner) ;
		
	}
	
	
	
	
}
