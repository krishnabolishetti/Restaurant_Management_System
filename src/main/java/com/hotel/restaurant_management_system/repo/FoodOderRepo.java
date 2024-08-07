package com.hotel.restaurant_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.restaurant_management_system.dto.FoodOder;

public interface FoodOderRepo extends JpaRepository<FoodOder, Integer> {

}
