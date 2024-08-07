package com.hotel.restaurant_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.restaurant_management_system.dto.Address;
import com.hotel.restaurant_management_system.dto.Branch;
import com.hotel.restaurant_management_system.dto.Customer;
import com.hotel.restaurant_management_system.dto.Employee;
import com.hotel.restaurant_management_system.dto.Manager;
import com.hotel.restaurant_management_system.dto.Menu;
import com.hotel.restaurant_management_system.services.BranchServices;
import com.hotel.restaurant_management_system.util.ResponseStructure;
import com.hotel.restaurant_management_system.util.ResponseStructureList;

@RestController
public class BranchController {

	
	@Autowired
	BranchServices branchServices;
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchServices.saveBranch(branch);
	}
	@GetMapping("/fetchbranchById")
	public ResponseEntity<ResponseStructure<Branch>>  fetchbranchById(@RequestParam int branchId) {
		return  branchServices.fetchbranchById(branchId);
	}
	@DeleteMapping("/deletebranchById")
	public ResponseEntity<ResponseStructure<Branch>> deletebranchById(@RequestParam int branchId) {
		
		return branchServices.deletebranchById(branchId);
	
	}
	@PutMapping("/updatebranch")
	public ResponseEntity<ResponseStructure<Branch>>  updatebranch(@RequestParam int oldbranchId,@RequestBody  Branch newbranch) {
		
		return branchServices.updatebranch(oldbranchId,newbranch);
	}
	@GetMapping("/fetchAllbranch")
	public ResponseEntity<ResponseStructureList<Branch>>  fetchAllbranch() {
		return branchServices.fetchAllbranch();
		
	}
	@PutMapping("/addExistingtAddresToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingtAddresToExistingBranch(@RequestParam int branchId,@RequestParam int addressId) {
		return branchServices.addExistingtAddresToExistingBranch(branchId, addressId);
	}
	@PutMapping("/addNewAddresToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewAddresToExistingBranch(@RequestParam int branchId,@RequestBody Address newaddres) {
		return branchServices.addNewAddresToExistingBranch(branchId, newaddres);
	}
	@PutMapping("/addExistingManagerToExistingBranch")
	public Branch addExistingManagerToExistingBranch(@RequestParam int branchId,@RequestParam int managerId) {
		return branchServices.addExistingManagerToExistingBranch(branchId, managerId);
	}

	@PutMapping("/addNewManagerToExistingBranch")
	public Branch addNewManagerToExistingBranch(@RequestParam int branchId,@RequestBody Manager newmanager) {
		return branchServices.addNewManagerToExistingBranch(branchId, newmanager);
	}
	@PutMapping("/addExistingMenuToExistingBranch")
	public Branch addExistingMenuToExistingBranch(@RequestParam int branchId,@RequestParam int menuId) {
		return branchServices.addExistingMenuToExistingBranch(branchId, menuId);
		
	}
	@PutMapping("/addNewmenuToExistingBranch")
	public Branch addNewmenuToExistingBranch(@RequestParam int branchId,@RequestBody Menu newmenu) {
		return branchServices.addNewmenuToExistingBranch(branchId, newmenu);
	}
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public Branch addExistingEmployeeToExistingBranch (@RequestParam int branchId,@RequestParam int employeeId) {
		return branchServices.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}
	@PutMapping("/addNewEmployeeToExistingBranch")
	public Branch addNewEmployeeToExistingBranch (@RequestParam int branchId,@RequestBody Employee newemployee ) {
		return branchServices.addNewEmployeeToExistingBranch(branchId, newemployee);
	}
	
	@PutMapping("/addExistingcustomerToExistingBranch")
	public Branch addExistingcustomerToExistingBranch (@RequestParam int branchId,@RequestParam int customerId) {
		return branchServices.addExistingcustomerToExistingBranch(branchId, customerId);
	}
	@PutMapping("/addNewCustomerToExistingBranch")
	public Branch addNewCustomerToExistingBranch (@RequestParam int branchId,@RequestBody Customer newcustomer ) {
		return branchServices.addNewCustomerToExistingBranch(branchId, newcustomer);
	}

}
