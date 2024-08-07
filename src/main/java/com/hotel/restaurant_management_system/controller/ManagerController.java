package com.hotel.restaurant_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.restaurant_management_system.dto.Manager;
import com.hotel.restaurant_management_system.services.ManagerServices;

@RestController
public class ManagerController {

	@Autowired
	ManagerServices managerServices;
	
	@PostMapping("/saveManager")
	public Manager saveManager(@RequestBody Manager manager) {
		return managerServices.saveManager(manager);
	}
	@GetMapping("/fetchManagerById")
	public Manager  fetchManagerById(@RequestParam int managerId) {
		return  managerServices.fetchManagerById(managerId);
	}
	@DeleteMapping("/deleteManagerById")
	public Manager deleteManagerById(@RequestParam int managerId) {
		
		return managerServices.deleteManagerById(managerId);
	
	}
	@PutMapping("/updateManager")
	public Manager  updateManager(@RequestParam int oldmanagerId,@RequestBody  Manager newmanager) {
		
		return managerServices.updateManager(oldmanagerId,newmanager);
	}
	@GetMapping("/fetchAllManager")
	public List<Manager>  fetchAllManager() {
		return managerServices.fetchAllManager();
		
	}
}
