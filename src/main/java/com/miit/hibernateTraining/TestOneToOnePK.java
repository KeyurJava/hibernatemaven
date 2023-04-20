package com.miit.hibernateTraining;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestOneToOnePK {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure("hibernate-one-to-one.cfg.xml")
				.buildSessionFactory();
	}
	
	public static void main(String[] args) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			User user = new User();
			user.setName("Pinkesh");

			UserAddress userAddress = new UserAddress();
			userAddress.setCity("City1");
			userAddress.setStreet("street1");
			userAddress.setZipcode("12345");
			userAddress.setUser(user);

			user.setUserAddress(userAddress);
			session.save(user);
			session.getTransaction().commit();

			String SQL_QUERY = "from User user";
			Query query = session.createQuery(SQL_QUERY);
			List<Object> userlist = query.list();
			for (Iterator iterator = userlist.iterator(); iterator.hasNext();) {
				User obj = (User) iterator.next();
				System.out.println("First Name: " + obj.getName());
				System.out.println("First Name: " + obj.getUserAddress().getCity());
			}

			/*
			 * String SQL_QUERY ="from User user"; Query query =
			 * session.createQuery(SQL_QUERY); //Query query
			 * =session.createSQLQuery("select * from USER_DETAILS");
			 * 
			 * List<Object[]> rows = query.list(); for(Object[] row : rows){ User user = new
			 * User(); user.setId(Long.parseLong(row[0].toString()));
			 * user.setName(row[1].toString()); System.out.println("ID: " + user.getId());
			 * System.out.println("First Name: " + user.getName()); }
			 * 
			 * List<Object> userlist = query.list(); for (Iterator iterator =
			 * userlist.iterator(); iterator.hasNext();) { User user = (User)
			 * iterator.next(); System.out.println("ID: " + user.getId());
			 * System.out.println("First Name: " + user.getName());
			 * System.out.println("First Name: " + user.getUserAddress().getCity());
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			// Actual contact insertion will happen at this step
			System.out.println("test");
			session.close();

		}
	}

}
