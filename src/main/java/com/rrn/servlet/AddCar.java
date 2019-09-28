package com.rrn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rrn.daos.CarDao;
import com.rrn.entities.Car;

@WebServlet("/AddCar")
public class AddCar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String Automatic = request.getParameter("isAutomatic");
		String AC = request.getParameter("hasAC");
		int price = (Integer.parseInt(request.getParameter("price")));
		
		boolean isAutomatic = false;
		
		if (Automatic.equals("yes")) isAutomatic = true;
		
		boolean hasAC = false;
		
		if (AC.equals("yes")) hasAC = true;
		
		Car newCar = new Car();
		
		newCar.setBrand(brand);
		newCar.setModel(model);
		newCar.setAutomatic(isAutomatic);
		newCar.setHasAc(hasAC);
		newCar.setPricePerDay(price);
		
		CarDao.saveCar(newCar);
		response.sendRedirect("successfullySavedCar.jsp");
		
	}

}
