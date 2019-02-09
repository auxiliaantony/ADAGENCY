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

import com.adagency.online.serv.InternetService;
import com.adagency.online.serv.TelevisionService;
import com.adagency.online.serv.AdminService;

@WebServlet("/AddInternet")
public class AddInternet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddInternet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()) {
			String websiteName = request.getParameter("websitename");
			String media = request.getParameter("media");
			String size= request.getParameter("size");
			String fromDate= request.getParameter("fromdate");
			SimpleDateFormat ad=new SimpleDateFormat("dd-mm-yyyy");
			Date fromdate1=ad.parse(fromDate);
			String toDate= request.getParameter("todate");
			SimpleDateFormat ad1=new SimpleDateFormat("dd-mm-yyyy");
			Date todate1=ad1.parse(toDate);
            String sourceType=request.getParameter("sourcetype");
            System.out.println("htmlsource   "+sourceType);
            String selected_sourceType=(sourceType.equals("film")?"film":sourceType.equals("product")?"product":"company");
			System.out.println("source   "+selected_sourceType);
            if(sourceType.equals("film"))
			{
            	InternetService.insert(websiteName,media,size,fromDate,toDate,sourceType);
				response.sendRedirect("film.html");
			}
			else if(sourceType.equals("product"))
			{
				InternetService.insert(websiteName,media,size,fromDate,toDate,sourceType);
				response.sendRedirect("product.html");
			}
			else if(sourceType.equals("company"))
			{
				InternetService.insert(websiteName,media,size,fromDate,toDate,sourceType);
				response.sendRedirect("company.html");
			}
            
            
           
			
				} catch (ParseException e) {
					
					e.printStackTrace();
				}

		
    }

		
	}


