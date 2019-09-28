package com.rrn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rrn.daos.CarDao;
import com.rrn.daos.ClientDao;
import com.rrn.daos.ReservationDao;
import com.rrn.entities.Car;
import com.rrn.entities.Client;
import com.rrn.entities.Reservation;

/**
 * Servlet implementation class AdminActions
 */
@WebServlet("/AdminActions")
public class AdminActions extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("adminSelectedAction");
		System.out.println(action);
		if (action.equals("Entire list of the company's cars")) {
			List<Car> allCars = CarDao.getCarsList();
			request.setAttribute("allCars", allCars); 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allCompanyCars.jsp");
			dispatcher.forward(request,response);
		}

		if (action.equals("Entire list of the company's clients")) {
			List<Client> allClients = ClientDao.getClientsList();
			request.setAttribute("allClients", allClients); 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allCompanyClients.jsp");
			dispatcher.forward(request,response);
		}

		if (action.equals("Full history of reservations")) {
			List<Reservation> allReservations = ReservationDao.getReservationsList();
			request.setAttribute("allReservations", allReservations); 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allReservations.jsp");
			dispatcher.forward(request,response);
		}
		
	}

}
