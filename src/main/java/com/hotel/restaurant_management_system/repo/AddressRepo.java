package com.hotel.restaurant_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.restaurant_management_system.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
