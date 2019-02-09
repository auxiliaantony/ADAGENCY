package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.serv.CompanyService;
import com.adagency.online.serv.FilmsService;


@WebServlet("/Addfilm")
public class Addfilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Addfilm() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try (PrintWriter out = response.getWriter()) {
			String directorName = request.getParameter("directorname");
			String filmName = request.getParameter("filmname");
			String heroName= request.getParameter("heroname");
			String musicDirector= request.getParameter("musicdirector");
			String producer= request.getParameter("producer");
			String releaseDate= request.getParameter("releasedate");
			SimpleDateFormat ad1=new SimpleDateFormat("dd-mm-yyyy");
			Date releaseDate1=ad1.parse(releaseDate);
			FilmsService.insert(directorName,filmName,heroName,musicDirector,producer,releaseDate1);
			response.sendRedirect("payment.html");
				}
		catch (ParseException e) {
					
					e.printStackTrace();
				}
		
	}

}
