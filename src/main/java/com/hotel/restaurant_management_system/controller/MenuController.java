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

import com.hotel.restaurant_management_system.dto.Menu;
import com.hotel.restaurant_management_system.services.Menuservices;

@RestController
public class MenuController {

	@Autowired
	Menuservices menuservices;
	
	@PostMapping("/saveMenu")
	public Menu saveMenu(@RequestBody Menu menu) {
		return menuservices.saveMenu(menu);
	}
	@GetMapping("/fetchMenuById")
	public Menu  fetchMenuById(@RequestParam int menuId) {
		return  menuservices.fetchMenuById(menuId);
	}
	@DeleteMapping("/deleteMenuById")
	public Menu deleteMenuById(@RequestParam int menuId) {
		
		return menuservices.deleteMenuById(menuId);
	
	}
	@PutMapping("/updateMenu")
	public Menu  updateMenu(@RequestParam int oldmenuId,@RequestBody  Menu newmenu) {
		
		return menuservices.updateMenu(oldmenuId,newmenu);
	}
	@GetMapping("/fetchAllMenu")
	public List<Menu>  fetchAllMenu() {
		return menuservices.fetchAllMenu();
		
	}
}
