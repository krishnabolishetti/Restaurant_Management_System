package com.hotel.restaurant_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int branchId;
			private String branchName;
			private long branchPhone;
			private double branchRevenue ;
			private String branchEmail;
			
			@OneToOne(cascade = CascadeType.ALL)
			Menu menu;
			
			@OneToOne(cascade = CascadeType.ALL)
			Address address;
			
			@OneToOne(cascade = CascadeType.ALL)
			Manager manager;
			
			@OneToMany(cascade = CascadeType.ALL)
			List<Employee> employee;
			
			@OneToMany(cascade = CascadeType.ALL)
			List<Customer> customers;

			public List<Customer> getCustomers() {
				return customers;
			}
			public void setCustomers(List<Customer> customers) {
				this.customers = customers;
			}
			public List<Employee> getEmployee() {
				return employee;
			}
			public void setEmployee(List<Employee> employee) {
				this.employee = employee;
			}
			public Menu getMenu() {
				return menu;
			}
			public void setMenu(Menu menu) {
				this.menu = menu;
			}
			public Manager getManager() {
				return manager;
			}
			public void setManager(Manager manager) {
				this.manager = manager;
			}
			public Address getAddress() {
				return address;
			}
			public void setAddress(Address address) {
				this.address = address;
			}
			public int getBranchId() {
				return branchId;
			}
			public void setBranchId(int branchId) {
				this.branchId = branchId;
			}
			public String getBranchName() {
				return branchName;
			}
			public void setBranchName(String branchName) {
				this.branchName = branchName;
			}
			public long getBranchPhone() {
				return branchPhone;
			}
			public void setBranchPhone(long branchPhone) {
				this.branchPhone = branchPhone;
			}
			public double getBranchRevenue() {
				return branchRevenue;
			}
			public void setBranchRevenue(double branchRevenue) {
				this.branchRevenue = branchRevenue;
			}
			public String getBranchEmail() {
				return branchEmail;
			}
			public void setBranchEmail(String branchEmail) {
				this.branchEmail = branchEmail;
			}
			
}
