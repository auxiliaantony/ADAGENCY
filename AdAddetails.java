package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.serv.AdDetailsService;
import com.adagency.online.serv.AdminService;


@WebServlet("/AdAddetails")
public class AdAddetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdAddetails() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			String adType = request.getParameter("adtype");
			String budjet=request.getParameter("budjet");
			String selected_budjet=(budjet.equals("LOW")?"low":budjet.equals("MEDIUM")?"medium":"high");
			String selected_adType=(adType.equals("MAGAZINE")?"magazine":adType.equals("INTERNET")?"internet":adType.equals("NEWSPAPER")?"newspaper":"television");
			System.out.println(selected_budjet);
			System.out.println(selected_adType);

			if(adType.equals("magazine"))
			{
				AdDetailsService.insert(adType,budjet);
				response.sendRedirect("magazine.html");
			}
			else if(adType.equals("newspaper"))
			{
				AdDetailsService.insert(adType,budjet);
				response.sendRedirect("newspaper.html");
			}
			else if(adType.equals("internet"))
			{
				AdDetailsService.insert(adType,budjet);
				response.sendRedirect("internet.html");
			}
			else
			{
				AdDetailsService.insert(adType,budjet);
				response.sendRedirect("television.html");
			}
			}
		}

	}


