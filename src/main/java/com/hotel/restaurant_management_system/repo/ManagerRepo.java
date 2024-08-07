package com.hotel.restaurant_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.restaurant_management_system.dto.Manager;
@Repository
public interface ManagerRepo extends JpaRepository<Manager, Integer> {

}
