package com.miit.hibernateTraining;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ADDRESS_COLLECTION")
public class UserAddressCollection implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6272645473400175462L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_training_OneToOne")
	@SequenceGenerator(name="hibernate_training_OneToOne", sequenceName="hibernate_training_OneToOne")
	@Column(name = "ID", nullable = false)
	private long id;
	@JoinTable(name = "USER_ADDRESS_DATA",joinColumns=@JoinColumn(name="USER_ID"))
	//@CollectionOfElements(fetch = FetchType.LAZY)
	Set<Address> userAddress = new HashSet<Address>();
	
	public void setUserAddress(Set<Address> userAddress) {
		this.userAddress = userAddress;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
}
