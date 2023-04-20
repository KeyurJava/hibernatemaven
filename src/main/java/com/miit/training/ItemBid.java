package com.miit.training;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author PINKESH
 *
 */
@Entity
@Table(name = "ITEM_BID")
public class ItemBid implements Serializable{
	
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
	
	/* @OneToMany annotation defines a many-valued association with one-to-many multiplicity.
	If the collection is defined using generics to specify the element type, the associated target entity type need not be specified; 
	otherwise the target entity class must be specified.The association may be bidirectional. In a bidirectional relationship, 
	one of the sides (and only one) has to be the owner: the owner is responsible for the association column(s) update. 
	To declare a side as not responsible for the relationship, the attribute mappedBy is used. mappedBy refers to the property name of 
	the association on the owner side. In our case, 	this is passport. As you can see, you don’t have to (must not) declare the join column 
	since it has already been declared on the owners side.*/
	//@OneToMany(mappedBy = "item")
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    @JoinColumn(name="BID_ID")
	private Set<Bid> bidSet = new HashSet<Bid>();
	
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
	public Set<Bid> getBidSet() {
		return bidSet;
	}


	public void setBidSet(Set<Bid> bidSet) {
		this.bidSet = bidSet;
	}

}
