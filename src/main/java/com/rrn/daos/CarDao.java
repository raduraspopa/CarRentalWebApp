package com.rrn.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rrn.entities.Car;
import com.rrn.entities.Client;
import com.rrn.entities.Reservation;
import com.rrn.service.ReservationService;

public class CarDao {
	
	public CarDao() {

	}

	static Configuration con = new Configuration().configure("hibernate.cfg.xml")
			                   .addAnnotatedClass(Car.class);

	static SessionFactory sf = con.buildSessionFactory();

	public static List<Car> getCarsList() {

		List<Car> carsList = new ArrayList();
		Session sessionObj = sf.openSession();
		carsList = (List<Car>) sessionObj.createQuery("FROM Car").list();
		sessionObj.close();

		return carsList;
	}
	
	public static void saveCar(Car c) {
		
		Session sessionObj = sf.openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(c);
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			System.out.println("Nu se poate salva masina");
			sqlException.printStackTrace();
			sessionObj.getTransaction().rollback();
		} finally {
			sessionObj.close();
		}
		
	}
	
	public static Car getCarByModel(String carModel) {
		List<Car> carsList = getCarsList();
		for (Car c : carsList) { if (c.getModel().equals(carModel)) {
			return c;
			
		    }	
		}
		return null;
	}
	
	public static List<String> getAvailableCars(Reservation r){
		
		List<Car> allCars = getCarsList();
		List<String> allCarModels = new ArrayList<>();
		List<String> availableCars = new ArrayList<>();
		
		for(Car c : allCars) {
			allCarModels.add(c.getModel());
		}
		
		for(String model : allCarModels) {
			if (ReservationService.isCarEligibleReservation(r, model)) {
				availableCars.add(model);
			}
		}
		for(String carModel : allCarModels)
		System.out.println(carModel);
		return availableCars;
		
	}
	
	public static void deleteCar(int carId) {
		Transaction transaction = null;
        try (Session session = sf.openSession()) {
        	
            transaction = session.beginTransaction();

            Car car = session.get(Car.class, carId);
            if (car != null) {
                session.delete(car);
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}
	
}
