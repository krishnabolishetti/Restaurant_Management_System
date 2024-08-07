package com.hotel.restaurant_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Restaurant {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int restauranId;
		private String restauranName;
		private long restauranPhone;
		private String restauranGST;
		private String restauranEmail;
		
		@OneToMany(cascade = CascadeType.ALL)
		List<Branch> branchs;
		
		public List<Branch> getBranchs() {
			return branchs;
		}
		public void setBranchs(List<Branch> branchs) {
			this.branchs = branchs;
		}
		public int getRestauranId() {
			return restauranId;
		}
		public void setRestauranId(int restauranId) {
			this.restauranId = restauranId;
		}
		public String getRestauranName() {
			return restauranName;
		}
		public void setRestauranName(String restauranName) {
			this.restauranName = restauranName;
		}
		public long getRestauranPhone() {
			return restauranPhone;
		}
		public void setRestauranPhone(long restauranPhone) {
			this.restauranPhone = restauranPhone;
		}
		public String getRestauranGST() {
			return restauranGST;
		}
		public void setRestauranGST(String restauranGST) {
			this.restauranGST = restauranGST;
		}
		public String getRestauranEmail() {
			return restauranEmail;
		}
		public void setRestauranEmail(String restauranEmail) {
			this.restauranEmail = restauranEmail;
		}
		
}
