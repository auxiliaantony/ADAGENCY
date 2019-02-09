package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.serv.CompanyService;
import com.adagency.online.serv.InternetService;


@WebServlet("/AdCompany")
public class AdCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdCompany() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()) {
			String companyName = request.getParameter("companyname");
			String address = request.getParameter("address");
			String branches= request.getParameter("branches");
			String mailId= request.getParameter("mailid");
			String phoneNumber= request.getParameter("phonenumber");
			CompanyService.insert(address,branches,companyName,mailId,phoneNumber);
			response.sendRedirect("payment.html");
				}
		
	}

}
