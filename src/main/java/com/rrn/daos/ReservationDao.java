package com.rrn.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rrn.entities.Car;
import com.rrn.entities.Reservation;

public class ReservationDao {
	public ReservationDao() {

	}

	static Configuration con = new Configuration().configure("hibernate.cfg.xml")
			                   .addAnnotatedClass(Reservation.class);

	static SessionFactory sf = con.buildSessionFactory();

	public static List<Reservation> getReservationsList() {

		List<Reservation> reservationsList = new ArrayList();
		Session sessionObj = sf.openSession();
		reservationsList = (List<Reservation>) sessionObj.createQuery("FROM Reservation").list();
		sessionObj.close();

		return reservationsList;
	}
	
	public static List<Reservation> getReservationsByCarModel(String carModel) {

		List<Car> carsList = CarDao.getCarsList();
		List<Reservation> allReservations = getReservationsList();
		List<Reservation> reservationsByCarModelList = new ArrayList();
		
		Car selectedCar = new Car();
		
		for (Car c : carsList) {
			if(c.getModel()==carModel) {
				selectedCar = c;
				break;
			   }
			}
		
		for (Reservation r : allReservations) {
			if(r.getCar_id()==selectedCar.getId()) {
				reservationsByCarModelList.add(r);
			}
		}
		
		return reservationsByCarModelList;
	}
	
	public static void saveReservation(Reservation r) {
		
		Session sessionObj = sf.openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(r);
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			System.out.println("Nu se poate salva rezervarea");
			sqlException.printStackTrace();
			sessionObj.getTransaction().rollback();
		} finally {
			sessionObj.close();
		}
		
	}
	
	public static void deleteReservation(int reservationId) {
		Transaction transaction = null;
        try (Session session = sf.openSession()) {
        	
            transaction = session.beginTransaction();

            Reservation reservation = session.get(Reservation.class, reservationId);
            if (reservation != null) {
                session.delete(reservation);
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
	
	public static List<Reservation> getReservationsByUserId(int userId){
		List<Reservation> allReservations = getReservationsList();
		List<Reservation> reservationsByUserId = new ArrayList();
		
		for(Reservation r : allReservations) {
			if(r.getClient_id()==userId) {
				reservationsByUserId.add(r);
			}
		}
		return reservationsByUserId;
	}
	
}
