package com.rrn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rrn.daos.CarDao;

@WebServlet("/DeleteCar")
public class DeleteCar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String carModel = request.getParameter("dropdownCarModel");
		System.out.println(carModel);
		int carId = Integer.parseInt(carModel.charAt(0)+"");
		System.out.println(carId);
		CarDao.deleteCar(carId);
		response.sendRedirect("successfullyDeletedCar.jsp");
	}

}
