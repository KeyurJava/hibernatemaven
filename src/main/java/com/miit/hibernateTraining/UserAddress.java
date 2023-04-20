package com.miit.hibernateTraining;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "USER_ADDRESS")
public class UserAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9156220645779906513L;
	
	@Id
	@GeneratedValue(generator="myForeignGenerator")
	@GenericGenerator(name="myForeignGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@Column(name = "ID", nullable = false)
	private Long id;

	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
