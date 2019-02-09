package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.serv.CompanyService;
import com.adagency.online.serv.OnlineCreditService;


@WebServlet("/Onlinecredit")
public class Onlinecredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Onlinecredit() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			String owner= request.getParameter("owner");
			String cvv= request.getParameter("cvv");
			String expirationdate= request.getParameter("expirationdate");
			String cardno= request.getParameter("cardno");
			
			OnlineCreditService.insert(owner,cvv,expirationdate,cardno);
			response.sendRedirect("landing.html");
				}
		
	}

	}

