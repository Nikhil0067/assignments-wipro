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
	
        //CREATE Operation
        /*
        Student obj = new Student();
        obj.setStd_name("Ankit");
        obj.setStd_city("Goa");
        session.persist(obj);
        t.commit();
        System.out.println("Data inserted successfully!");
        */

        // READ Operation
        /*
        Student obj = session.get(Student.class, 2);
        if (obj != null) {
            System.out.println("ID: " + obj.getId()+" Name: " + obj.getStd_name()+" City: " + obj.getStd_city());
        } else {
            System.out.println("Student not found!");
        }
        t.commit(); // optional here
        */

        // UPDATE Operation
 
        /*
        Student obj = session.get(Student.class, 2);
        if (obj != null) {
            obj.setStd_name("Virat");
            obj.setStd_city("Bangalore");
            session.persist(obj);
            t.commit();
            System.out.println("Data updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
        */
		
        // DELETE Operation
		
        Student obj = session.get(Student.class, 2);
        if (obj != null) {
            session.remove(obj);
            t.commit();
            System.out.println("Data deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
        

        session.close();
        sf.close();
    }
}