package com.rrn.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rrn.entities.Client;

public class ClientDao {

	public ClientDao() {

	}

	static Configuration con = new Configuration().configure("hibernate.cfg.xml")
			                   .addAnnotatedClass(Client.class);

	static SessionFactory sf = con.buildSessionFactory();

	public static List<Client> getClientsList() {

		List<Client> clientsList = new ArrayList();
		Session sessionObj = sf.openSession();
		clientsList = (List<Client>) sessionObj.createQuery("FROM Client").list();
		sessionObj.close();

		return clientsList;
	}
	
	public static void saveClient(Client c) {
		
		Session sessionObj = sf.openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(c);
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			System.out.println("Nu se poate salva clientul");
			sqlException.printStackTrace();
			sessionObj.getTransaction().rollback();
		} finally {
			sessionObj.close();
		}
		
	}
}
