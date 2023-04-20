package com.miit.hibernateTraining;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.miit.hibernateTraining.util.HibernateUtil;

public class TestOneToMany {

	public static void main(String[] args) {

		try {
			SessionFactory sf = HibernateUtil.buildSessionFactory("hibernate-one-to-many.cfg.xml");
			Session session = sf.openSession();

			/*
			 * DepartmentOneToMany department = new DepartmentOneToMany();
			 * department.setDepartmentName("Sales");
			 */

			DepartmentOneToMany department = session.get(DepartmentOneToMany.class, 3L);
			// session.delete(department);

			EmployeeOneToMany emp1 = new EmployeeOneToMany("NinaAfter1", "Mayers1", "11111");
			EmployeeOneToMany emp2 = new EmployeeOneToMany("TonyAfter1", "Almeida1", "21122");
			emp1.setDepartment(department);
			emp2.setDepartment(department);

			Set<EmployeeOneToMany> employeeOneToManies = new HashSet<EmployeeOneToMany>();
			employeeOneToManies.add(emp1);
			employeeOneToManies.add(emp2);

			/*
			 * department.setEmployees(employeeOneToManies);
			 * 
			 * session.beginTransaction(); session.save(department);
			 */
			/*
			 * session.save(emp1);
			 * 
			 * session.save(emp2); session.getTransaction().commit();
			 */
			/*
			 * session.save(emp1);
			 * 
			 * session.save(emp2);
			 * 
			 * 
			 * session.getTransaction().commit();
			 */

			String SQL_QUERY = "from DepartmentOneToMany department";
			Query query = session.createQuery(SQL_QUERY);
			List<DepartmentOneToMany> userlist = query.list();
			for (Iterator iterator = userlist.iterator(); iterator.hasNext();) {
				DepartmentOneToMany obj = (DepartmentOneToMany) iterator.next();
				System.out.println("deaprtment Name: " + obj.getDepartmentName());

				Thread.sleep(5000);
				System.out.println("Later Name: " + obj.getEmployees());

			}

			// for(MAP.entry<String,String> entry : map.entry)

			/*
			 * DepartmentOneToMany department = new DepartmentOneToMany();
			 * department.setDepartmentName("Sales"); session.save(department);
			 * EmployeeOneToMany emp1 = new EmployeeOneToMany("Nina", "Mayers", "111");
			 * //EmployeeOneToMany emp2 = new EmployeeOneToMany("Tony", "Almeida", "222");
			 * emp1.setDepartment(department);
			 * //department.setEmployees(employeeOneToManies); session.save(emp1);
			 */

			/*
			 * DepartmentOneToMany department = new DepartmentOneToMany();
			 * department.setDepartmentName("Sales"); session.save(department);
			 * EmployeeOneToMany emp1 = new EmployeeOneToMany("Nina", "Mayers", "111");
			 * EmployeeOneToMany emp2 = new EmployeeOneToMany("Tony", "Almeida", "222");
			 * emp1.setDepartment(department); emp2.setDepartment(department);
			 * session.save(emp1); session.save(emp2);
			 */
			// session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
