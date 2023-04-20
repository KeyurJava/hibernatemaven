package com.miit.training.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "PERSON_PER_CONCRETE_CLASS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonTablePerConcreteClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_training_example")
	@SequenceGenerator(name="hibernate_training_example", sequenceName="hibernate_training_example")
	@Column(name = "PERSON_ID")
	private Long personId;
	
	@Column(name = "FIRSTNAME")
	private String firstname;
	
	@Column(name = "LASTNAME")
	private String lastname;
	
	public PersonTablePerConcreteClass() {
	
	}
	public PersonTablePerConcreteClass(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
