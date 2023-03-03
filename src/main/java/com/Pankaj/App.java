package com.Pankaj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory Factory = cfg.buildSessionFactory();
		// creating student
//		Student st1 = new Student();
//		st1.setId(102);
//		st1.setName("SHON");
//		st1.setCity("NEW JURSY");
//		System.out.println(st1);

		// creating object of address class

		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("NAGPUR");
		ad.setOpen(true);
		ad.setAddeddate(new Date());
		ad.setX(1234.245);
		
		//Reading image
		FileInputStream fis = new FileInputStream("src/main/java/pic.png");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		Session session = Factory.openSession();

		session.beginTransaction();
		// session.save(st1);
		session.save(ad);
		session.getTransaction().commit();
		session.close();
		System.out.println("Done");
	}
}
