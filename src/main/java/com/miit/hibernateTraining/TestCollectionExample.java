package com.miit.hibernateTraining;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCollectionExample {
	
	public static void main(String[] args) {
		Session session = null;

		try{
			SessionFactory sessionFactory = new Configuration().configure("hibernate-collection.cfg.xml")
					.buildSessionFactory(); 
			 session = sessionFactory.openSession();
			 Item item = new Item();
			 item.setName("test");
			 Set<String> imageList = new HashSet<String>();
			// session.save(item);
			 for (int i = 0; i < 2; i++) {
				 imageList.add("Test"+i);
				//session.save(itemImage);
			}
			 item.setImageList(imageList);
			 session.save(item);
			 /*item = (Item)session.get(Item.class, item.getId());
			 Set<String> itemList = item.getImageList();
			 for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				String fileName = (String) iterator.next();
				System.out.println("file Name is ::"+ fileName);
				
			}*/

		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			System.out.println("test");
			 session.flush();
			 session.close();
			}
		
	}


}
