package com.hotel.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dto.Address;
import com.hotel.restaurant_management_system.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(@RequestBody Address address) {
		return addressRepo.save(address);
	}
	public Address  fetchAddressById(@RequestParam int addressId) {
		Optional<Address> address=addressRepo.findById(addressId);
		if(address.isPresent()) {
			return  address.get();
		}else {
			return null;
		}
	
	}
	
	public Address deleteAddressById(@RequestParam int addressId) {
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	
	public Address  updateAddress(@RequestParam int oldaddressId,@RequestBody  Address newaddress) {
		newaddress.setAddressId(oldaddressId);;
		return addressRepo.save(newaddress);
	}
	public List<Address>  fetchAllAddress() {
		return addressRepo.findAll();
		
	}
}
