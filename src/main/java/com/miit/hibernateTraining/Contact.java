package com.miit.hibernateTraining;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Pinkesh Thakker
 *
**/ 
@Entity
@org.hibernate.annotations.Entity(mutable = false)
@Table(name = "CONTACT")
public class Contact implements Serializable{
	/*
	 * That's the expected behavior. When using @GeneratedValue(strategy = GenerationType.AUTO), the JPA provider will pick an appropriate strategy for the particular database. In the case of Oracle, 
	 * this will be SEQUENCE and, since you did not specify anything, Hibernate will use a single global sequence called hibernate_sequence. 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="hibernate_training")
	
	@Column(name = "ID", nullable = false)
	private long id;

	private static final long serialVersionUID = 8445652793219376453L;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="street", column = @Column(name="HOME_STREET")),
		@AttributeOverride(name = "zipcode" , column = @Column(name="HOME_ZIPCODE")),
		@AttributeOverride(name = "city", column = @Column(name="HOME_CITY"))})
	
	private Address homeAddress;
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Embedded
	@AttributeOverrides({@AttributeOverride(name="street", column = @Column(name="OFFICE_STREET")),
		@AttributeOverride(name = "zipcode" , column = @Column(name="OFFICE_ZIPCODE")),
		@AttributeOverride(name = "city", column = @Column(name="OFFICE_CITY"))})
	private Address officeAddress;
	
	
	
	
	/**
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/** 
	 * @return Last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param string Sets the Email
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string Sets the First Name
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string sets the Last Name
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param l Sets the ID
	 */
	public void setId(long l) {
		id = l;
	}

}
