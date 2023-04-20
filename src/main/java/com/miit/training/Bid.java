package com.miit.training;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BID")
public class Bid implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="hibernate_training_example")
	@SequenceGenerator(name="hibernate_training_example", sequenceName="hibernate_training_example")
	@Column(name = "ID", nullable = false)
	private long id;
	@Column(name = "BID_NAME")
	private String bidName;
	
	//@ManyToOne(targetEntity = com.nihilent.training.ItemBid.class)
	//@JoinColumn(name = "ID", nullable = false )	
	@ManyToOne
    @JoinColumn(name="BID_ID",nullable=false)
	private ItemBid item;
	
	public ItemBid getItem() {
		return item;
	}
	public void setItem(ItemBid item) {
		this.item = item;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBidName() {
		return bidName;
	}
	public void setBidName(String bidName) {
		this.bidName = bidName;
	}
	
	}
