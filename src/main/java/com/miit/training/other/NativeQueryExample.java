package com.miit.training.other;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.miit.training.Insurance;

public class NativeQueryExample {
	public static void main(String[] args) {
		Session session = null;

		try{
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session =sessionFactory.openSession();
			/* Hibernate Native Query Average Examle*/
		 	String sql ="select stddev(ins.invested_amount) as stdErr, "+
		 		" avg(ins.invested_amount) as mean "+
		 		" from insurance ins";
		 	Query query = session.createSQLQuery(sql);
	 		//Double [] amount = (Double []) query.uniqueResult(); 
		 	Object [] amount = (Object []) query.uniqueResult(); 
 			System.out.println("mean amount: " + amount[0]);
 			System.out.println("stdErr amount: " + amount[1]);

 			/* Example to show Native query to select all the objects from database */
 			/* Selecting all the objects from insurance table */
 			List insurance = session.createSQLQuery("select  {ins.*}  from insurance ins")
			.addEntity("ins", Insurance.class)
		    .list();
			for (Iterator it = insurance.iterator(); it.hasNext();) {
				Insurance insuranceObject = (Insurance) it.next();
				System.out.println("ID: " + insuranceObject.getLngInsuranceId());
				System.out.println("Name: " + insuranceObject.getInsuranceName());
			}
			
	        session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
