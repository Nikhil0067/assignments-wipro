package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf =cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
        // CREATE Operation
        /*
        Employee emp = new Employee();
        emp.setEmp_name("Amit");
        emp.setEmp_cmp("TCS");
        emp.setEmp_salary(40000);
        session.persist(emp);
        t.commit();
        System.out.println("Employee added successfully!");
        */

        // READ Operation
        /*
        Employee emp = session.get(Employee.class, 1);
        if (emp != null) {
            System.out.println("ID: " + emp.getId()+" Name: " + emp.getEmp_name()+" Company: " + emp.getEmp_cmp()+" Salary: " + emp.getEmp_salary());
        } else {
            System.out.println("Employee not found!");
        }
        t.commit(); // optional here
        */

        // UPDATE Operation
        /*
        Employee emp = session.get(Employee.class, 1);
        if (emp != null) {
            emp.setEmp_name("Ankit");
            emp.setEmp_cmp("Infosys");
            emp.setEmp_salary(60000);
            session.persist(emp);
            t.commit();
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
        */

  
        // DELETE Operation
        
        Employee emp = session.get(Employee.class, 1);
        if (emp != null) {
            session.remove(emp);
            t.commit();
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
        

        session.close();
        sf.close();
	}
}
