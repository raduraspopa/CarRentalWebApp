package com.rrn.service;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.rrn.daos.CarDao;
import com.rrn.daos.ReservationDao;
import com.rrn.entities.Reservation;

public class ReservationService {
	
	static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy HH");

	public static boolean isValidDate(String date) {

		try {
			DateTime.parse(date, dateTimeFormatter);
		} catch (Exception pe) {
			return false;
		}
		return true;

	}
	
	//verificam daca masina e disponibila pentru perioada aleasa
	public static boolean isCarEligibleReservation(Reservation newRes, String carModel) {
		
		DateTime newResStartDate = DateTime.parse(newRes.getStart_date(), dateTimeFormatter);
		DateTime newResEndDate = DateTime.parse(newRes.getEnd_date(), dateTimeFormatter);
		
		List<Reservation> sameCarReservations = ReservationDao.getReservationsByCarModel(carModel);
		
		//verificam ca data de inceput a rezervarii noi sa nu fie in cursul unei alte rezervari
		for(Reservation r : sameCarReservations) {
			if((newResStartDate.isAfter(DateTime.parse(r.getStart_date(), dateTimeFormatter)))
			  &&(newResStartDate.isBefore(DateTime.parse(r.getEnd_date(), dateTimeFormatter))))
			{
				System.out.println("startDate-ul nou este in intervalul altei rezervari");
				return false;
			}
		}
		
		//verificam ca data de sfarsit a rezervarii noi sa nu fie in cursul unei alte rezervari
		for(Reservation r : sameCarReservations) {
			if((newResEndDate.isAfter(DateTime.parse(r.getStart_date(), dateTimeFormatter)))
			  &&(newResEndDate.isBefore(DateTime.parse(r.getEnd_date(), dateTimeFormatter))))
			{
				System.out.println("endDate-ul nou este in intervalul altei rezervari");
				return false;
			}
		}
		
		//verificam ca in cursul rezervarii noi sa nu fie total inclusa o rezervare anterioara
		for(Reservation r : sameCarReservations) {
			if(((DateTime.parse(r.getStart_date(), dateTimeFormatter)).isAfter(newResStartDate))
			  &&((DateTime.parse(r.getEnd_date(), dateTimeFormatter)).isBefore(newResEndDate)))
			{
				System.out.println("in intervalul rezervarii noi este inclusa o rezervare anterioara");
				return false;
			}
		}
		
		//verificam ca rezervarea noua sa nu se suprapuna total cu o rezervare anterioara
		for(Reservation r : sameCarReservations) {
			if(((DateTime.parse(r.getStart_date(), dateTimeFormatter)).equals(newResStartDate))
			  &&((DateTime.parse(r.getEnd_date(), dateTimeFormatter)).equals(newResEndDate)))
			{
				System.out.println("rezervarea noua se suprapune cu o rezervare anterioara");
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean threeDaysCancellationRule(int userId, Reservation r) {
		
		DateTime startDate = DateTime.parse(r.getStart_date(), dateTimeFormatter);
		DateTime currentDate = DateTime.now();
		DateTime plus3Days = currentDate.plusDays(3);
		
	    if((startDate.equals(plus3Days))||(startDate.isAfter(plus3Days))) {
		  return true;
	    } else return false;
	}
	
	public static int calculateReservationPrice(String carModel, String startDate, String endDate) {
		
		DateTime start = DateTime.parse(startDate, dateTimeFormatter);
		DateTime end = DateTime.parse(endDate, dateTimeFormatter);
		int carPricePerDay = CarDao.getCarByModel(carModel).getPricePerDay();
		int nrOfDays = Days.daysBetween(start.withTimeAtStartOfDay() , end.withTimeAtStartOfDay() ).getDays();
		
		return carPricePerDay*nrOfDays;
	}
	
}
