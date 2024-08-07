package com.hotel.restaurant_management_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.restaurant_management_system.dao.MenuDao;
import com.hotel.restaurant_management_system.dto.Menu;

@Service
public class Menuservices {
@Autowired
	MenuDao menuDao;
	
public Menu saveMenu(@RequestBody Menu menu) {
	return menuDao.saveMenu(menu);
}
public Menu  fetchMenuById(@RequestParam int menuId) {
	return  menuDao.fetchMenuById(menuId);
}

public Menu deleteMenuById(@RequestParam int menuId) {
	
	return menuDao.deleteMenuById(menuId);

}

public Menu  updateMenu(@RequestParam int oldmenuId,@RequestBody  Menu newmenu) {
	
	return menuDao.updateMenu(oldmenuId,newmenu);
}
public List<Menu>  fetchAllMenu() {
	return menuDao.fetchAllMenu();
	
}

}
