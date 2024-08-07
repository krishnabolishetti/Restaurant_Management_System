package com.hotel.restaurant_management_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dao.ManagerDao;
import com.hotel.restaurant_management_system.dto.Manager;

@Service
public class ManagerServices {

	@Autowired
	ManagerDao managerDao;
	
	public Manager saveManager(@RequestBody Manager manager) {
		return managerDao.saveManager(manager);
	}
	public Manager  fetchManagerById(@RequestParam int managerId) {
		return  managerDao.fetchManagerById(managerId);
	}
	
	public Manager deleteManagerById(@RequestParam int managerId) {
		
		return managerDao.deleteManagerById(managerId);
	
	}
	
	public Manager  updateManager(@RequestParam int oldmanagerId,@RequestBody  Manager newmanager) {
		
		return managerDao.updateManager(oldmanagerId,newmanager);
	}
	public List<Manager>  fetchAllManager() {
		return managerDao.fetchAllManager();
		
	}
}
