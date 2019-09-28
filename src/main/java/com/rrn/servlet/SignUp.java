package com.rrn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rrn.daos.ClientDao;
import com.rrn.entities.Client;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			                                     throws ServletException, IOException {
		
		String cnp = request.getParameter("cnp");
		String desiredUname = request.getParameter("desiredUname");
		String desiredPass = request.getParameter("desiredPass");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		
		Client newClient = new Client();
		
		newClient.setClientCnp(cnp);
		newClient.setClientUserName(desiredUname);
		newClient.setClientPassword(desiredPass);
		newClient.setClientFirstName(firstName);
		newClient.setClientLastName(lastName);
		newClient.setClientPhone(phoneNumber);
		
		ClientDao.saveClient(newClient);
		
	}

}
