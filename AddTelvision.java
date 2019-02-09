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

import com.adagency.online.serv.MagazineService;
import com.adagency.online.serv.NewsPaperService;
import com.adagency.online.serv.TelevisionService;

@WebServlet("/AddTelvision")
public class AddTelvision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddTelvision() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()) {
			String channelName = request.getParameter("channelname");
			String duration = request.getParameter("duration");
			String fromDate= request.getParameter("fromdate");
			SimpleDateFormat ad=new SimpleDateFormat("dd-mm-yyyy");
			Date fromDate1=ad.parse(fromDate);
			String toDate= request.getParameter("todate");
			SimpleDateFormat ad1=new SimpleDateFormat("dd-mm-yyyy");
			Date toDate1=ad1.parse(toDate);
			String sourceType=request.getParameter("sourcetype");
			
			String selected_sourceType=(sourceType.equals("FILM")?"film":sourceType.equals("PRODUCT")?"product":"company");
			
			
			if(sourceType.equals("film"))
			{
				TelevisionService.insert(channelName,duration,fromDate,toDate,sourceType);
				response.sendRedirect("film.html");
			}
			else if(sourceType.equals("product"))
			{
				TelevisionService.insert(channelName,duration,fromDate,toDate,sourceType);
				response.sendRedirect("product.html");
			}
			else if(sourceType.equals("company"))
			{
				TelevisionService.insert(channelName,duration,fromDate,toDate,sourceType);
				response.sendRedirect("company.html");
			}
			
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
		
	}

}
