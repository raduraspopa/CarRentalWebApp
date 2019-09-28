package com.rrn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rrn.daos.CarDao;
import com.rrn.daos.ReservationDao;
import com.rrn.entities.Reservation;
import com.rrn.service.ReservationService;

@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int clientId = (int) request.getSession().getAttribute("clientId");
		String startDate = request.getParameter("reservationStartDate");
		String endDate = request.getParameter("reservationEndDate");
		String carModel = request.getParameter("dropdownCarModel");
		
		boolean areDatesValid = ReservationService.isValidDate(startDate)
				                &&ReservationService.isValidDate(endDate);
		
		if (!areDatesValid) {
			response.sendRedirect("notValidDate.jsp");
		}
		
		boolean isCarEligibleReservation = false;
		List<String> availableCars = new ArrayList();
		
		Reservation newReservation = new Reservation();
		
		if(areDatesValid) {
			
		newReservation.setClient_id(clientId);
		newReservation.setStart_date(startDate);
		newReservation.setEnd_date(endDate);
		newReservation.setCar_id(CarDao.getCarByModel(carModel).getId());
		newReservation.setPrice(ReservationService.calculateReservationPrice(carModel, startDate, endDate));
		
		isCarEligibleReservation = ReservationService.isCarEligibleReservation(newReservation, carModel);
		
		}
		
		if(isCarEligibleReservation) {
			ReservationDao.saveReservation(newReservation);
			response.sendRedirect("successfullySavedReservation.jsp");
		} else {
			availableCars = CarDao.getAvailableCars(newReservation);
			request.setAttribute("availableCars", availableCars); 
			System.out.println("cars available " + availableCars.size());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carNotAvailable.jsp");
			dispatcher.forward(request,response);
		}
	System.out.println(isCarEligibleReservation);
	}

}
