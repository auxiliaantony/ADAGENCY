package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.serv.DeleteService;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Delete() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		try (PrintWriter out = response.getWriter()) {
			String id1=request.getParameter("adid");
			Integer id=Integer.parseInt(id1);
			System.out.println(id);
			if (id==null){
				out.println("details needed to provide this service");
			} else {
				DeleteService.deleteaddetails(id);
				out.println("your details have been deleted successfully");
			}	
			}
		
		
		
		
		
	
	}

	}

