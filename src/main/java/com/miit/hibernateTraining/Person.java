package com.miit.hibernateTraining;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_1")
public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5963670447555005952L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_training_example")
	@SequenceGenerator(name="hibernate_training_example", sequenceName="hibernate_training_example")
	@Column(name = "ID", nullable = false)
	private long id;

	@Column(name = "NAME")
	private String name;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "CERT_ID")
	private Certificate certificate;


	public Certificate getCertificate() {
		return certificate;
	}


	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
