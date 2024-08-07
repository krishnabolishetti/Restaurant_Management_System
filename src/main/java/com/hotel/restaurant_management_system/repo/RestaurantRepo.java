package com.hotel.restaurant_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.restaurant_management_system.dto.Restaurant;
@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

}
