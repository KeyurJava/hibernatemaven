package com.miit.hibernateTraining;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_CERTIFICATE_1")
public class Certificate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6598815692538881043L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_training_example_2")
	@SequenceGenerator(name="hibernate_training_example_2", sequenceName="hibernate_training_example_2", initialValue = 100)
	@Column(name = "ID", nullable = false)
	private long id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "PERSON_ID")
	private Person person;
		

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "CODE")
	private String code;
	
	@Column(name = "CERTIFICATE_NAME")
	private String certName;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

}
