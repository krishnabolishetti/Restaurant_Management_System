package com.hotel.restaurant_management_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.Exception.CustomerIdNotFound;
import com.hotel.restaurant_management_system.Exception.FoodOderIdNotFound;
import com.hotel.restaurant_management_system.Exception.OwnerIdNotFound;
import com.hotel.restaurant_management_system.dao.CustomerDao;
import com.hotel.restaurant_management_system.dao.FoodOderDao;
import com.hotel.restaurant_management_system.dto.Customer;
import com.hotel.restaurant_management_system.dto.FoodOder;
import com.hotel.restaurant_management_system.util.ResponseStructure;
import com.hotel.restaurant_management_system.util.ResponseStructureList;

@Service
public class CustomerServices {

	@Autowired
	ResponseStructure<Customer> responseStructure;
	
	@Autowired
	ResponseStructureList<Customer>  responseStructureList;
	
	@Autowired
	FoodOderDao foodOderDao;
	
	@Autowired
	CustomerDao customerDao;
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		responseStructure.setMessage(" successfuly customer saved in db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new  ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Customer>>  fetchCustomerById(@RequestParam int customerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		if(customer!=null) {
			responseStructure.setMessage("successfully feched the customer id from the db");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(customerDao.fetchCustomerById(customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw  new CustomerIdNotFound();
		}
		 
	}
	
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int customerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
        if (customer!=null) {
        	responseStructure.setMessage("successfully customer deleted from Db");
        	responseStructure.setStatusCode(HttpStatus.OK.value());
        	responseStructure.setData(customerDao.deleteCustomerById(customerId));
        	return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
        }else {
        	throw new CustomerIdNotFound();
        }
        	
	}
	
	public ResponseEntity<ResponseStructure<Customer>>  updateCustomer(@RequestParam int oldcustomerId,@RequestBody  Customer newcustomer) {
		Customer customer=customerDao.fetchCustomerById(oldcustomerId);
        if(customer!=null) {
        	responseStructure.setMessage("successfully updated customer to db");
        	responseStructure.setStatusCode(HttpStatus.OK.value());
        	responseStructure.setData(customerDao.updateCustomer(oldcustomerId,newcustomer));
        	return new  ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
        }else {
        	throw new CustomerIdNotFound();
        }
		
	}
	public ResponseEntity<ResponseStructureList<Customer>>  fetchAllCustomer() {
		responseStructureList.setMessage("successfully fetched all date from db ");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(customerDao.fetchAllCustomer());
		return new ResponseEntity<ResponseStructureList<Customer>>(responseStructureList, HttpStatus.FOUND);
		
	}
	public ResponseEntity<ResponseStructure<Customer>> addExistingfoodToExistingcustomer (int customerId,int foododerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
        FoodOder foodOder=foodOderDao.fetchFoodOderById(foododerId);
        if(customer == null) {
        	throw new CustomerIdNotFound();
        } else if(foodOder == null) {
        	throw new FoodOderIdNotFound();
        }
        else {
        	responseStructure.setMessage("successfully addExistingfoodToExistingcustomer to db ");
        	responseStructure.setStatusCode(HttpStatus.OK.value());
        	responseStructure.setData(customerDao.addExistingfoodToExistingcustomer(customerId, foododerId));
           return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
        }
        
	
	}

	public ResponseEntity<ResponseStructure<Customer>> addNewfoodToExistingCustomer (int customerId,FoodOder newfoododer ) {
		Customer customer=customerDao.fetchCustomerById(customerId);
        if(customer!=null) {
        	responseStructure.setMessage(" successfully addNewfoodToExistingCustomer to db ");
        	responseStructure.setStatusCode(HttpStatus.OK.value());
        	responseStructure.setData(customerDao.addNewfoodToExistingCustomer(customerId, newfoododer));
          return new  ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
        }else {
        	throw new CustomerIdNotFound();
        }

	}

}





