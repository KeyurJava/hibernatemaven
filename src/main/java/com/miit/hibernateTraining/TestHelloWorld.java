package com.miit.hibernateTraining;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestHelloWorld {

	public static void main(String[] args) {
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure("hibernate-one-to-one.cfg.xml").buildSessionFactory();

			session = sessionFactory.openSession();

			/*
			 * Registration registration = new Registration();
			 * registration.setFirstName("XYZ2"); registration.setLastName("PQR2");
			 * registration.setMiddleName("MRP2"); registration.setAddress("Address2");
			 * 
			 * registration.setEmail("test@gmail.com");
			 * registration.setPhoneNumber("123456");
			 * registration.setSecondaryEmail("testse@gmail.com");
			 * 
			 * session.beginTransaction();
			 * 
			 * session.save(registration); session.getTransaction().commit();
			 */

			Registration registrationRetreived = (Registration) session.get(Registration.class, 2L);
			if (null != registrationRetreived)
				System.out.println("Object retreived with Id :" + registrationRetreived.getFirstName()); // // //
			//registrationRetreived.setFirstName("firstName");

			// session.saveOrUpdate(registrationRetreived);
			String HQL_QUERY = "from Registration reg";
			Query query = session.createQuery(HQL_QUERY);
			List<Registration> userlist = query.list();
			for (Iterator iterator = userlist.iterator(); iterator.hasNext();) {
				Registration object = (Registration) iterator.next();
				System.out.println("Fname is ::" + object.getFirstName());
			}

			// session.beginTransaction();
			/*
			 * Registration registration = new Registration(); registration.setId(7L);
			 * registration.setFirstName("firstName"); registration.setLastName("lastName");
			 * registration.setMiddleName("mName"); session.saveOrUpdate(registration);
			 * session.getTransaction().commit();
			 * 
			 * Registration registrationRetreived =
			 * (Registration)session.get(Registration.class, 7L);
			 * System.out.println("Object retreived with Id 1:"+registrationRetreived.
			 * getFirstName()); registrationRetreived.setFirstName("firstName");
			 * 
			 * 
			 * 
			 * String HQL_QUERY ="from Registration reg"; Query query =
			 * session.createQuery(HQL_QUERY); // Query query List<Registration> userlist =
			 * query.list(); for (Iterator iterator = userlist.iterator();
			 * iterator.hasNext();) { Registration object = (Registration)iterator.next();
			 * System.out.println("Fname is ::"+object.getFirstName());
			 * 
			 * }
			 */

			/*
			 * Query sqlquery = session.createSQLQuery("select * from user_registration");
			 * List<Object[]> rows = sqlquery.list(); for (Object[] row : rows) {
			 * Registration reg = new Registration(); reg.setFirstName(row[1].toString());
			 * reg.setLastName(row[2].toString()); if (null != row[3])
			 * reg.setMiddleName(row[3].toString()); System.out.println("First Name::" +
			 * reg.getFirstName()); System.out.println("Last Name: " + reg.getLastName());
			 * 
			 * }
			 */

			/*
			 * HelloWorldAnnotation helloWorld ssssssssssssssssssssssssssssssssssss=
			 * (HelloWorldAnnotation)session.get(HelloWorldAnnotation.class, 1L);
			 * System.out.println("Object retreived with Id 1:"+helloWorld.getFirstName());
			 * String HQL_QUERY ="from HelloWorldAnnotation helloWorldAnnotation"; Query
			 * query = session.createQuery(HQL_QUERY); // Query query
			 * =session.createSQLQuery("select * from USER_DETAILS");
			 * 
			 * List<Object[]> rows = query.list(); for(Object[] row : rows){ User user = new
			 * User(); user.setId(Long.parseLong(row[0].toString()));
			 * user.setName(row[1].toString()); System.out.println("ID: " + user.getId());
			 * System.out.println("First Name: " + user.getName()); }
			 * 
			 * List<Object> userlist = query.list(); for (Iterator iterator =
			 * userlist.iterator(); iterator.hasNext();) { HelloWorldAnnotation user =
			 * (HelloWorldAnnotation) iterator.next(); System.out.println("ID: " +
			 * user.getId()); System.out.println("First Name: " + user.getFirstName());
			 * System.out.println("First Name: " + user.getLastName());
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			// Actual contact insertion will happen at this step
			System.out.println("test");
			// sessionFactory.close();
			session.close();

		}

	}

}
