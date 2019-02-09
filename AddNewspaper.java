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

import com.adagency.online.serv.AdDetailsService;
import com.adagency.online.serv.InternetService;
import com.adagency.online.serv.NewsPaperService;


@WebServlet("/AddNewspaper")
public class AddNewspaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddNewspaper() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()) {
			String newspaperName = request.getParameter("newspapername");
			String pageNo = request.getParameter("pageno");
			String size= request.getParameter("adsize");
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
				NewsPaperService.insert(newspaperName,pageNo,size,fromDate,toDate,sourceType);
				response.sendRedirect("film.html");
			}
			else if(sourceType.equals("product"))
			{
				NewsPaperService.insert(newspaperName,pageNo,size,fromDate,toDate,sourceType);
				response.sendRedirect("product.html");
			}
			else if(sourceType.equals("company"))
			{
				NewsPaperService.insert(newspaperName,pageNo,size,fromDate,toDate,sourceType);
				response.sendRedirect("company.html");
			}
			NewsPaperService.insert(newspaperName,pageNo,size,fromDate,toDate,sourceType);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}

		
	}

}
