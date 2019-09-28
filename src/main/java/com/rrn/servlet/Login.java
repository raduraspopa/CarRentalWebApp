package com.rrn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.rrn.daos.AdminDao;
import com.rrn.daos.CarDao;
import com.rrn.daos.ClientDao;
import com.rrn.daos.ReservationDao;
import com.rrn.entities.Admin;
import com.rrn.entities.Car;
import com.rrn.entities.Client;
import com.rrn.entities.Reservation;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		int currentClientId = 0;
		int currentAdminId = 0;
		
		List<Client> clientsList = ClientDao.getClientsList();
		List<Admin> adminsList = AdminDao.getAdminsList();
		boolean adminIsValid = false;
		boolean userIsValid = false;
		
		for(Client c : clientsList) {
		
		if((uname.equals(c.getClientUserName()))&&(pass.equals(c.getClientPassword()))) {
			userIsValid=true;
			currentClientId = c.getClientId();
			break;
		    }
		}
			
		for(Admin a : adminsList) {
					
		      if((uname.equals(a.getUsername()))&&(pass.equals(a.getPass()))) {
			  
		    	  adminIsValid=true;
		    	  currentAdminId = a.getAdmin_id();
						break;
						}
		} 
		
		
		
		if(userIsValid==true) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("clientId", currentClientId);
			response.sendRedirect("http://localhost:8080/WebAppCarRental/carReservationRequest.jsp");
			
			} else if (adminIsValid==true){
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("http://localhost:8080/WebAppCarRental/Admin.jsp");
				
			} else {
			response.sendRedirect("http://localhost:8080/WebAppCarRental/index.jsp");
		}
		
	}
	
}
		
	


