package com.Pankaj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		//get or Load 
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		//get student:102
		Student student = session.get(Student.class, 2);
		System.out.println(student);
		
		//get address
		
		Address ad = new Address();
		Address address = session.get(Address.class, 1);
		System.out.println(address);
		
		
		session.close();
		factory.close();
	}
}
