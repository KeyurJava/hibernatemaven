package com.miit.training;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable{
	
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
	
	@OneToOne(mappedBy = "item")
	@JoinColumn(name = "ITEM_ID")
	private ItemImage itemImage;
	
	public ItemImage getItemImage() {
		return itemImage;
	}


	public void setItemImage(ItemImage itemImage) {
		this.itemImage = itemImage;
	}


	//@org.hibernate.annotations.CollectionOfElements(targetElement = java.lang.String.class)
	@JoinTable(name = "ITEM_IMAGE", joinColumns = @JoinColumn(name = "ITEM_ID") )
	@Column(name = "FILENAME")
	@org.hibernate.annotations.OrderBy(clause = "FILENAME asc")
	private Set<String> imageList = new HashSet<String>();
	
	
	

	public Set<String> getImageList() {
		return imageList;
	}


	public void setImageList(Set<String> imageList) {
		this.imageList = imageList;
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
