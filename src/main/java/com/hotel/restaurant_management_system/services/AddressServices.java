package com.hotel.restaurant_management_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.Exception.AddressIdNotFound;
import com.hotel.restaurant_management_system.dao.AddressDao;
import com.hotel.restaurant_management_system.dto.Address;
import com.hotel.restaurant_management_system.util.ResponseStructure;
import com.hotel.restaurant_management_system.util.ResponseStructureList;

@Service
public class AddressServices {

	@Autowired
	ResponseStructure<Address> responseStructure;
	@Autowired
	ResponseStructureList<Address> responseStructureList;
	
	@Autowired
	AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		responseStructure.setMessage("successfully address saved in db ");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new  ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED); 
	}
	public ResponseEntity<ResponseStructure<Address>>  fetchAddressById(@RequestParam int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null) {
			
		
		responseStructure.setMessage("successfully address fetched in db ");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(addressDao.fetchAddressById(addressId));
		return new  ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND); 
		}else {
			throw new AddressIdNotFound();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null) {
		responseStructure.setMessage("successfully address saved in db ");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return new  ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK); 
		}else {
			throw new AddressIdNotFound();
		}
	
	}
	
	public  ResponseEntity<ResponseStructure<Address>>  updateAddress(@RequestParam int oldaddressId,@RequestBody  Address newaddress) {
		Address address=addressDao.fetchAddressById(oldaddressId);
		if(address!=null) {
			responseStructure.setMessage("successfully address saved in db ");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.updateAddress(oldaddressId,newaddress ));
			return new  ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK); 
			}else {
				throw new AddressIdNotFound();
			}
	}
	public ResponseEntity<ResponseStructureList<Address>>  fetchAllAddress() {
		responseStructureList.setMessage("successfully address saved in db ");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(addressDao.fetchAllAddress());
		return new  ResponseEntity<ResponseStructureList<Address>>(responseStructureList, HttpStatus.OK); 
		
		
	}
	
}
