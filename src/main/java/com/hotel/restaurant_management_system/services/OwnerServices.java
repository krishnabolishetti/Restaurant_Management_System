package com.hotel.restaurant_management_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.Exception.OwnerIdNotFound;
import com.hotel.restaurant_management_system.Exception.RestaurantIdNotFound;
import com.hotel.restaurant_management_system.dao.OwnerDao;
import com.hotel.restaurant_management_system.dao.RestaurantDao;
import com.hotel.restaurant_management_system.dto.Owner;
import com.hotel.restaurant_management_system.dto.Restaurant;
import com.hotel.restaurant_management_system.util.ResponseStructure;
import com.hotel.restaurant_management_system.util.ResponseStructureList;

@Service
public class OwnerServices {

	@Autowired
	RestaurantDao restaurantDao;
	
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	ResponseStructure<Owner> responseStructure;
	
	@Autowired 
	ResponseStructureList<Owner> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner ) {
		responseStructure.setMessage("successfully owner data inserted in  to Db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Owner>>  fetchownerById(int ownerId) {
		Owner owner=ownerDao.fetchownerById(ownerId);
		if(owner!=null) {
		responseStructure.setMessage("successfully owner feched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(ownerDao.fetchownerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND) ;
		}else {
			throw new OwnerIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Owner>> deleteownerById(@RequestParam int ownerId) {
		Owner owner=ownerDao.fetchownerById(ownerId);
		if(owner!=null) {
		responseStructure.setMessage("successfully owner delete from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.deleteownerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK) ;
		}else {
			throw new OwnerIdNotFound();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Owner>>  updateowner(@RequestParam int oldownerId,@RequestBody Owner newowner) {
		
		Owner owner=ownerDao.fetchownerById(oldownerId);
		if(owner!=null) {
		responseStructure.setMessage("successfully owner feched from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.updateowner(oldownerId, newowner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK) ;
		}else {
			throw new OwnerIdNotFound();
		}
		
	}
	public ResponseEntity<ResponseStructureList<Owner>> fetchAllowner() {
		responseStructureList.setMessage("successsfully all owners in db");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(ownerDao.fetchAllowner());
		return new ResponseEntity<ResponseStructureList<Owner>>(responseStructureList, HttpStatus.FOUND); 
		
	}
	public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToexistingOwner(int ownerId,int restaurantId) {
		Owner owner=ownerDao.fetchownerById(ownerId);
		Restaurant restaurant=restaurantDao.fetchRestaurantById(restaurantId);
		if(owner ==null) {
			throw new OwnerIdNotFound();
		}
		else if (restaurant ==null){
			throw new RestaurantIdNotFound();
		}
		else {
			responseStructure.setMessage("successfully addedExistingRestaurantToexistingOwner in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.addExistingRestaurantToexistingOwner(ownerId, restaurantId));
			
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		}
		
	}
	public ResponseEntity<ResponseStructure<Owner>>  addNewRestaurantToexistingOwner (int ownerId,Restaurant newrestaurant) {
		
		Owner owner=ownerDao.fetchownerById(ownerId);
		if(owner!=null) {
		responseStructure.setMessage("successfully addedNewRestaurantToexistingOwner from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.addNewRestaurantToexistingOwner(ownerId, newrestaurant));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK) ;
		
		}else {
			throw new OwnerIdNotFound();
		}
		
		
	}
}
