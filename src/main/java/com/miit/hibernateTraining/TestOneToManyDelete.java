package com.miit.hibernateTraining;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneToManyDelete {
	
	public static void main(String[] args) {
		Session session = null;
		try{
				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
			 session = sessionFactory.openSession();
			 //ItemBid itemBid;
			 //itemBid = (ItemBid)session.get(ItemBid.class, Long.parseLong("1"));
			 //session.delete(itemBid);
			 
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
