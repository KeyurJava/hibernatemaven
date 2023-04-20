package com.miit.training;

import java.io.Serializable;

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
@Table(name = "ITEM_IMAGE")
public class ItemImage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6598815692538881043L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_training_example_2")
	@SequenceGenerator(name="hibernate_training_example_2", sequenceName="hibernate_training_example_2")
	@Column(name = "ID", nullable = false)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;
	
	
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	

	@Column(name = "POSITION")
	private long position;
	
	@Column(name = "FILENAME")
	private String fileName;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

}
