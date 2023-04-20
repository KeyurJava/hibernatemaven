package com.miit.hibernateTraining;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCollectionInsertPrimaryKey {
	
	public static void main(String[] args) {
		Session session = null;

		try{
			SessionFactory sessionFactory = new Configuration().configure("hibernate-collection.cfg.xml")
					.buildSessionFactory(); 
			 session = sessionFactory.openSession();
			 UserAddressCollectionPrimaryKey user = new UserAddressCollectionPrimaryKey();
			 Address address = new Address();
			 address.setCity("insertCollection Cityf");
			 address.setStreet("insertCollection Streetf");
			 address.setZipcode("insertCollection codef");
			 Address secodnAddress = new Address();
			 secodnAddress.setCity("insertCollection City1");
			 secodnAddress.setStreet("insertCollection Street2");
			 secodnAddress.setZipcode("insertCollection code3");
			 
			 Set<Address> addressSet = new HashSet<Address>();
			 addressSet.add(address);
			 addressSet.add(secodnAddress);
			 
			 user.setName("Nihilent");
			 user.setUserAddress(addressSet);
			 session.save(user);
			 session.flush();
			 session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			System.out.println("test");
			
			}
	}
		


}
