package com.hotel.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dto.Manager;
import com.hotel.restaurant_management_system.repo.ManagerRepo;

@Repository
public class ManagerDao {

	@Autowired
	ManagerRepo managerRepo;
	
	public Manager saveManager(@RequestBody Manager manager) {
		return managerRepo.save(manager);
	}
	public Manager  fetchManagerById(@RequestParam int managerId) {
		Optional<Manager> manager= managerRepo.findById(managerId);
		if(manager.isPresent()) {
			return manager.get();
		}else {
			return null;
		}
		
	}
	
	public Manager deleteManagerById(@RequestParam int managerId) {
		Manager manager=fetchManagerById(managerId);
		managerRepo.delete(manager);
		return manager;
	}
	
	public Manager  updateManager(@RequestParam int oldmanagerId,@RequestBody  Manager newmanager) {
		newmanager.setManagerId(oldmanagerId);;
		return managerRepo.save(newmanager);
	}
	public List<Manager>  fetchAllManager() {
		return managerRepo.findAll();
		
	}
}
