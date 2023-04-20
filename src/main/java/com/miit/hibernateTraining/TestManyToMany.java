package com.miit.hibernateTraining;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miit.hibernateTraining.util.HibernateUtil;
 
public class TestManyToMany {
 
    public static void main(String[] args) {
 
    	SessionFactory sf = HibernateUtil.buildSessionFactory("hibernate-many-to-many.cfg.xml");
    	//SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        
        Meeting meeting1 = new Meeting("Quaterly Sales meeting");
        Meeting meeting2 = new Meeting("Weekly Status meeting");
        
        Student student1 = new Student("Sergey", "Brin");
        Student student2 = new Student("Larry", "Page");

        student1.getMeetings().add(meeting1);
        student1.getMeetings().add(meeting2);
        student2.getMeetings().add(meeting1);
        session.save(student1);
        session.save(student2);

        
        /*meeting1.getStudents().add(student1);
        meeting1.getStudents().add(student2);
        meeting2.getStudents().add(student1);
        session.save(meeting1);
        session.save(meeting2);
        */
        
        session.getTransaction().commit();
        session.close();
    }
}