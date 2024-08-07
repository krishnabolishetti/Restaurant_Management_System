package com.hotel.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dto.Menu;
import com.hotel.restaurant_management_system.repo.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	MenuRepo menuRepo;
	
	public Menu saveMenu(@RequestBody Menu menu) {
		return menuRepo.save(menu);
	}
	public Menu  fetchMenuById(@RequestParam int menuId) {
		Optional<Menu> menu=  menuRepo.findById(menuId);
		if(menu.isPresent()) {
			return menu.get();
		}else {
			return null;
		}
	}
	
	public Menu deleteMenuById(@RequestParam int menuId) {
		Menu menu=fetchMenuById(menuId);
		menuRepo.delete(menu);
		return menu;
	}
	
	public Menu  updateMenu(@RequestParam int oldmenuId,@RequestBody  Menu newmenu) {
		newmenu.setMenuId(oldmenuId);;
		return menuRepo.save(newmenu);
	}
	public List<Menu>  fetchAllMenu() {
		return menuRepo.findAll();
		
	}
}
