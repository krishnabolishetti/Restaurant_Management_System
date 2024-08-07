package com.hotel.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dto.Customer;
import com.hotel.restaurant_management_system.dto.FoodOder;
import com.hotel.restaurant_management_system.repo.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	FoodOderDao foodOderDao;
	
	@Autowired
	CustomerRepo customerRepo;
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	public Customer  fetchCustomerById(@RequestParam int customerId) {
		Optional<Customer> customer= customerRepo.findById(customerId);
		if(customer.isPresent()) {
			return customer.get();
		}else {
			return null;
		}
		
	}
	
	public Customer deleteCustomerById(@RequestParam int customerId) {
		Customer customer=fetchCustomerById(customerId);
		customerRepo.delete(customer);
		return customer;
	}
	
	public Customer  updateCustomer(@RequestParam int oldcustomerId,@RequestBody  Customer newcustomer) {
		newcustomer.setCustomerId(oldcustomerId);;
		return customerRepo.save(newcustomer);
	}
	public List<Customer>  fetchAllCustomer() {
		return customerRepo.findAll();
		
	}
	public Customer addExistingfoodToExistingcustomer (int customerId,int foododerId) {
		Customer customer=fetchCustomerById(customerId);
		FoodOder foodOder=foodOderDao.fetchFoodOderById(foododerId);
		List<FoodOder> foodOders=customer.getFoodOder();
		foodOders.add(foodOder);
		customer.setFoodOder(foodOders);
		return  saveCustomer(customer);
	}

	
	public Customer addNewfoodToExistingCustomer (int customerId,FoodOder newfoododer ) {
		Customer customer=fetchCustomerById(customerId);
		List<FoodOder> foodOders=customer.getFoodOder();
		foodOders.add(newfoododer);
		customer.setFoodOder(foodOders);
		return saveCustomer(customer);
	}

}




