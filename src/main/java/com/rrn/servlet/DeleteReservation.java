package com.rrn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rrn.daos.ClientDao;
import com.rrn.daos.ReservationDao;
import com.rrn.entities.Client;
import com.rrn.entities.Reservation;
import com.rrn.service.ReservationService;

@WebServlet("/DeleteReservation")
public class DeleteReservation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String startDate = request.getParameter("reservationStartDate");
		String endDate = request.getParameter("reservationEndDate");
		
		List<Client> clientsList = ClientDao.getClientsList();
		List<Reservation> reservationsList = ReservationDao.getReservationsList();
		int clientId = 0;
		
		for(Client c : clientsList) {
			if ((c.getClientUserName().equals(uname))&&(c.getClientPassword().equals(pass))) {
				clientId = c.getClientId();
			}
		}
		
		for(Reservation r : reservationsList) {
			if((r.getClient_id()==clientId)
			  &&(r.getStart_date().equals(startDate))
			  &&(r.getEnd_date().equals(endDate))) {
				if(ReservationService.threeDaysCancellationRule(clientId, r)) {
					ReservationDao.deleteReservation(r.getReservation_id());
					response.sendRedirect("successfullyDeletedReservation.jsp");
					break;
				} else response.sendRedirect("reservationCouldNotBeDeleted.jsp");
			}
		}
	}

}
