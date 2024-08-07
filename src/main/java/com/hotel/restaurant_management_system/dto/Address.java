package com.hotel.restaurant_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int addressId;
			private int addressPlotNo;
			private String addressStreet;
			private String  addressLandMark ;
			private int addressPinCode;
			private String addressCity;
			public int getAddressId() {
				return addressId;
			}
			public void setAddressId(int addressId) {
				this.addressId = addressId;
			}
			public int getAddressPlotNo() {
				return addressPlotNo;
			}
			public void setAddressPlotNo(int addressPlotNo) {
				this.addressPlotNo = addressPlotNo;
			}
			public String getAddressStreet() {
				return addressStreet;
			}
			public void setAddressStreet(String addressStreet) {
				this.addressStreet = addressStreet;
			}
			public String getAddressLandMark() {
				return addressLandMark;
			}
			public void setAddressLandMark(String addressLandMark) {
				this.addressLandMark = addressLandMark;
			}
			public int getAddressPinCode() {
				return addressPinCode;
			}
			public void setAddressPinCode(int addressPinCode) {
				this.addressPinCode = addressPinCode;
			}
			public String getAddressCity() {
				return addressCity;
			}
			public void setAddressCity(String addressCity) {
				this.addressCity = addressCity;
			}
			
}
