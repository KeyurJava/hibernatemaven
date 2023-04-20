package com.miit.training.inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="OWNER_PER_CONCRETE_CLASS")
@AttributeOverrides({
    @AttributeOverride(name="firstname", column=@Column(name="FIRSTNAME")),
    @AttributeOverride(name="lastname", column=@Column(name="LASTNAME"))
})
public class OwnerTablePerConcreteClass extends PersonTablePerConcreteClass {

	@Column(name="stocks")
	private Long stocks;
	
	@Column(name="partnership_stake")
	private Long partnershipStake;

	public OwnerTablePerConcreteClass() {
	}
	
	public OwnerTablePerConcreteClass(String firstname, String lastname, Long stocks, Long partnershipStake) {
		
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
