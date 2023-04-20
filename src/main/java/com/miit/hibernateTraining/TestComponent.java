
package com.miit.hibernateTraining;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestComponent {
	public static void main(String[] args) {
		Session session = null;

		try{
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure("hibernate-component.cfg.xml")
					.buildSessionFactory();
			 //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			 session =sessionFactory.openSession();
			// Transaction tx = session.beginTransaction();
				//Create new instance of Contact and set values in it by reading them from form object
			 	System.out.println("Inserting Record");
				Contact contact = new Contact();
				Address homeAddress = new Address();
				Address officeAddress = new Address();
				homeAddress.setCity("Pune");
				homeAddress.setStreet("VIMANNAGAR");
				homeAddress.setZipcode("411014");
				
				officeAddress.setCity("Pune");
				officeAddress.setStreet("NAGARROAD");
				officeAddress.setZipcode("411014");
				contact.setHomeAddress(homeAddress);
				contact.setOfficeAddress(officeAddress);
				contact.setFirstName("Pinkesh");
				contact.setLastName("Thakker");
				contact.setEmail("pinkesh.thakker@nihilent.com");
				session.save(contact);
				//tx.commit();
				session.flush();
				session.close();

				System.out.println("Done");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			System.out.println("test");
			
			}
		
	}
}
