package com.miit.training.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="OWNER_TABLE_PER_SUB_CLASS")
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class OwnerTablePerSubClass extends PersonTablePerSubClass {

	@Column(name="stocks")
	private Long stocks;
	
	@Column(name="partnership_stake")
	private Long partnershipStake;

	public OwnerTablePerSubClass() {
	}
	
	public OwnerTablePerSubClass(String firstname, String lastname, Long stocks, Long partnershipStake) {
		
		super(firstname, lastname);
		
		this.stocks = stocks;
		this.partnershipStake = partnershipStake;
	}

	public Long getStocks() {
		return stocks;
	}

	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}

	public Long getPartnershipStake() {
		return partnershipStake;
	}

	public void setPartnershipStake(Long partnershipStake) {
		this.partnershipStake = partnershipStake;
	}
	
}
