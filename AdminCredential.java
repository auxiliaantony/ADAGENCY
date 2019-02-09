
package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.model.Admin;
import com.adagency.online.model.UserProfile1;
import com.adagency.online.serv.AdminService;
import com.adagency.online.serv.CredentialService;
import com.adagency.online.serv.CredentialStatus;
import com.adagency.online.serv.LoginService;
import com.adagency.online.serv.UserProfileService1;

@WebServlet("/AdminCredential")
public class AdminCredential extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminCredential() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try (PrintWriter out = response.getWriter()) {
			System.out.println("welcome");
			String firstname = request.getParameter("firstname");
			String password = request.getParameter("password");
			System.out.println("emailid"+firstname);
			System.out.println("password"+password);
			
			Admin res =AdminService.get(firstname);
			if (res == null) {
				//out.println("AGAIN LOGIN");
				request.getRequestDispatcher("login.html").include(request, response);
			} else 
				if (res.getPassword().equals(password)) {
					response.sendRedirect("addetails.html");
					out.println("LOGIN SUCCESS");
					
				} else {
					//out.println("Login Error");
					request.getRequestDispatcher("login.html").include(request, response);
				
				}
			
			
	}

}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			}
		
	
	

}
