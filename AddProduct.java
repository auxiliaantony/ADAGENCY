package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.serv.CompanyService;
import com.adagency.online.serv.ProductService;


@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddProduct() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()) {
			String productName = request.getParameter("companyname");
			String offer = request.getParameter("offer");
			String price= request.getParameter("price");
			String warrenty= request.getParameter("warrenty");
			String features= request.getParameter("features");
			ProductService.insert(productName,offer,price,warrenty,features);
			response.sendRedirect("payment.html");
			
				}
		
	}

}
