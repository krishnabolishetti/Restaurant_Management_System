package com.hotel.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dto.Address;
import com.hotel.restaurant_management_system.dto.Branch;
import com.hotel.restaurant_management_system.dto.Customer;
import com.hotel.restaurant_management_system.dto.Employee;
import com.hotel.restaurant_management_system.dto.Manager;
import com.hotel.restaurant_management_system.dto.Menu;
import com.hotel.restaurant_management_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	EmployeeDao employeeDao;
    @Autowired
	MenuDao menuDao;
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	BranchRepo branchRepo;
	public Branch saveBranch(@RequestBody Branch branch) {
		return branchRepo.save(branch);
	}
	public Branch  fetchbranchById(@RequestParam int branchId) {
		Optional<Branch> branch= branchRepo.findById(branchId);
		if(branch.isPresent()) {
			return branch.get();
		}else {
			return null;
		}
		
	}
	
	public Branch deletebranchById(@RequestParam int branchId) {
		Branch branch=fetchbranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	
	public Branch  updatebranch(@RequestParam int oldbranchId,@RequestBody  Branch newbranch) {
		newbranch.setBranchId(oldbranchId);;
		return branchRepo.save(newbranch);
	}
	public List<Branch>  fetchAllbranch() {
		return branchRepo.findAll();
		
	}
	public Branch addExistingtAddresToExistingBranch( int branchId, int addressId) {
		Branch branch=fetchbranchById(branchId);
		Address address=addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	public Branch addNewAddresToExistingBranch(int branchId,Address newaddres) {
		Branch branch=fetchbranchById(branchId);
		branch.setAddress(newaddres);
		return  saveBranch(branch);
	}
	public Branch addExistingManagerToExistingBranch( int branchId, int managerId) {
		Branch branch=fetchbranchById(branchId);
		Manager manager=managerDao.fetchManagerById(managerId);
		branch.setManager(manager);
		return  saveBranch(branch);
	}
	public Branch addNewManagerToExistingBranch(int branchId,Manager newmanager) {
		Branch branch=fetchbranchById(branchId);
		branch.setManager(newmanager);
		return saveBranch(branch) ;
	}

	public Branch addExistingMenuToExistingBranch( int branchId, int menuId) {
		Branch branch=fetchbranchById(branchId);
		Menu menu=menuDao.fetchMenuById(menuId);
		branch.setMenu(menu);
		return  saveBranch(branch);
	}
	public Branch addNewmenuToExistingBranch(int branchId, Menu newmenu) {
		Branch branch=fetchbranchById(branchId);
		branch.setMenu(newmenu);;
		return saveBranch(branch) ;
	}
	public Branch addExistingEmployeeToExistingBranch (int branchId,int employeeId) {
		Branch branch=fetchbranchById(branchId);
		Employee employees=employeeDao.fetchEmployeeById(employeeId);
		List<Employee> employees2=branch.getEmployee();
		employees2.add(employees);
		branch.setEmployee(employees2);
		return  saveBranch(branch);
	}
	public Branch addNewEmployeeToExistingBranch (int branchId,Employee newemployee ) {
		Branch  branch=fetchbranchById(branchId);
		List<Employee> employee=branch.getEmployee();
		employee.add(newemployee);
		branch.setEmployee(employee);
		return saveBranch(branch) ;
	}

	public Branch addExistingcustomerToExistingBranch (int branchId,int customerId) {
		Branch branch=fetchbranchById(branchId);
		Customer customer=customerDao.fetchCustomerById(customerId);
		List<Customer> customers=branch.getCustomers();
		customers.add(customer);
		branch.setCustomers(customers);
		return saveBranch(branch);
	}
	
	public Branch addNewCustomerToExistingBranch (int branchId,Customer newcustomer ) {
		Branch  branch=fetchbranchById(branchId);
		List<Customer> customers=branch.getCustomers();
		customers.add(newcustomer);
		branch.setCustomers(customers);
		return saveBranch(branch);
	}

}






