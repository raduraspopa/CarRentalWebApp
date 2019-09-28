package com.rrn.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rrn.entities.Admin;
import com.rrn.entities.Client;

public class AdminDao {

	static Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Admin.class);

	static SessionFactory sf = con.buildSessionFactory();

	public static void saveAdmin(Admin a) {

		Session sessionObj = sf.openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(a);
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			System.out.println("Nu se poate salva admin-ul");
			sqlException.printStackTrace();
			sessionObj.getTransaction().rollback();
		} finally {
			sessionObj.close();
		}

	}

	public static List<Admin> getAdminsList() {
		List<Admin> adminsList = new ArrayList();
		Session sessionObj = sf.openSession();
		adminsList = (List<Admin>) sessionObj.createQuery("FROM Admin").list();
		sessionObj.close();

		return adminsList;
	}
}
