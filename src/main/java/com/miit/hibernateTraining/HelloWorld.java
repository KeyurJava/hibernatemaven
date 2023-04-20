package com.miit.hibernateTraining;

import java.io.Serializable;


public class HelloWorld implements Serializable{
	
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String firstName;

}
