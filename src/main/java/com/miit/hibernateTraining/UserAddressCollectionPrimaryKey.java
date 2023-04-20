package com.miit.hibernateTraining;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_ADDRESS_COLLECTION_PK")
public class UserAddressCollectionPrimaryKey implements Serializable {

	private static final long serialVersionUID = 6272645473400175462L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_training_OneToOne")
	@SequenceGenerator(name="hibernate_training_OneToOne", sequenceName="hibernate_training_OneToOne")
	@Column(name = "ID", nullable = false)
	private long id;
	
/* We are not going to use Set as we need the collection which supports indexing so we are going to change it to Arraylist that is the good options 
 * 
 * */
	
	@JoinTable(name = "USER_ADDRESS_DATA_PK",joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name = "hi-lo", strategy = "hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID")}, generator = "hi-lo", type = @Type(type="long"))
	//@CollectionOfElements
	Collection<Address> userAddress = new ArrayList<Address>();
	
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
