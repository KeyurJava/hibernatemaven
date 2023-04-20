package com.miit.hibernateTraining.util;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
 
    //private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory sessionFactory = null;
 
    public static SessionFactory buildSessionFactory(String fileName) {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	SessionFactory sessionFactory = new Configuration().configure(fileName)
					.buildSessionFactory();
                    
        	return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

