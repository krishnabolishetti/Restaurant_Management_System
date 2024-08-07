package com.hotel.restaurant_management_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.Exception.AddressIdNotFound;
import com.hotel.restaurant_management_system.Exception.BranchIdNotFound;
import com.hotel.restaurant_management_system.dao.AddressDao;
import com.hotel.restaurant_management_system.dao.BranchDao;
import com.hotel.restaurant_management_system.dto.Address;
import com.hotel.restaurant_management_system.dto.Branch;
import com.hotel.restaurant_management_system.dto.Customer;
import com.hotel.restaurant_management_system.dto.Employee;
import com.hotel.restaurant_management_system.dto.Manager;
import com.hotel.restaurant_management_system.dto.Menu;
import com.hotel.restaurant_management_system.dto.Owner;
import com.hotel.restaurant_management_system.util.ResponseStructure;
import com.hotel.restaurant_management_system.util.ResponseStructureList;
@Service
public class BranchServices {

	@Autowired
	AddressDao addressDao;
	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		responseStructure.setMessage("successfully Branch data inserted in  to Db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Branch>>  fetchbranchById(@RequestParam int branchId) {
		Branch branch=branchDao.fetchbranchById(branchId);
		if(branch != null) {
		responseStructure.setMessage("successfully Branch data fetched from Db");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(branchDao.fetchbranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	     }else {
	    	 throw new BranchIdNotFound();
	     }
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deletebranchById(@RequestParam int branchId) {
		Branch branch=branchDao.fetchbranchById(branchId);
		if(branch != null) {
		responseStructure.setMessage("successfully Branch data deleted in  to Db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.deletebranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}else {
		throw new BranchIdNotFound();
	}
	}
	
	public ResponseEntity<ResponseStructure<Branch>>  updatebranch(@RequestParam int oldbranchId,@RequestBody  Branch newbranch) {
		Branch branch=branchDao.fetchbranchById(oldbranchId);
		if(branch != null) {
		responseStructure.setMessage("successfully Branch data updated in  to Db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.updatebranch(oldbranchId,newbranch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}else {
		throw new BranchIdNotFound();
	}
	}
	public ResponseEntity<ResponseStructureList<Branch>>  fetchAllbranch() {
		responseStructureList.setMessage("successfully Branch data updated in  to Db");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(branchDao.fetchAllbranch());
		return new ResponseEntity<ResponseStructureList<Branch>>(responseStructureList, HttpStatus.FOUND);
		
		
	}
	public ResponseEntity<ResponseStructure<Branch>> addExistingtAddresToExistingBranch( int branchId, int addressId) {
		Branch branch=branchDao.fetchbranchById(branchId);
		Address address=addressDao.fetchAddressById(addressId);
		if(branch == null) {
			throw new BranchIdNotFound();
		}
		else if(address == null) {
			throw new AddressIdNotFound();
		}else {
			responseStructure.setMessage("successfully addExistingtAddresToExistingBranch in Db ");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingtAddresToExistingBranch(branchId, addressId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
		
	}
	public ResponseEntity<ResponseStructure<Branch>> addNewAddresToExistingBranch(int branchId,Address newaddres) {
		Branch branch=branchDao.fetchbranchById(branchId);
		if(branch == null) {
			responseStructure.setMessage("successfully addExistingtAddresToExistingBranch in Db ");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addNewAddresToExistingBranch(branchId, newaddres));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}else {
			throw  new BranchIdNotFound();
		}
	}
	
	public Branch addExistingManagerToExistingBranch( int branchId, int managerId) {
		return branchDao.addExistingManagerToExistingBranch(branchId, managerId);
	}

	public Branch addNewManagerToExistingBranch(int branchId,Manager newmanager) {
		return branchDao.addNewManagerToExistingBranch(branchId, newmanager);
	}
	public Branch addExistingMenuToExistingBranch( int branchId, int menuId) {
		return branchDao.addExistingMenuToExistingBranch(branchId, menuId);
		
	}
	public Branch addNewmenuToExistingBranch(int branchId, Menu newmenu) {
		return branchDao.addNewmenuToExistingBranch(branchId, newmenu);
	}
	public Branch addExistingEmployeeToExistingBranch (int branchId,int employeeId) {
		return branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}
	public Branch addNewEmployeeToExistingBranch (int branchId,Employee newemployee ) {
		return branchDao.addNewEmployeeToExistingBranch(branchId, newemployee);
	}
	
	public Branch addExistingcustomerToExistingBranch (int branchId,int customerId) {
		return branchDao.addExistingcustomerToExistingBranch(branchId, customerId);
	}
	public Branch addNewCustomerToExistingBranch (int branchId,Customer newcustomer ) {
		return branchDao.addNewCustomerToExistingBranch(branchId, newcustomer);
	}



	
	
	
	
	
}
