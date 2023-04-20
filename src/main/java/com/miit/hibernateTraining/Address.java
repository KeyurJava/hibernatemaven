package com.miit.hibernateTraining;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "ADDRESS_STREET", nullable = false)
	private String street;
	@Column(name = "ZIP_CODE", nullable = false)
	private String zipcode;
	@Column(name = "CITY", nullable = false)
	private String city;

}
