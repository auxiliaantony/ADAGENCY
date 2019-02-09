package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.serv.UserProfileService1;

@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//doGet(request, response);
				response.setContentType("text/html");
				try (PrintWriter out = response.getWriter()) {
					//int id = Integer.parseInt(request.getParameter("i"));
					String firstName = request.getParameter("firstname");
					String lastName = request.getParameter("lastname");
					String userName = request.getParameter("username");
					String emailId = request.getParameter("emailid");
					String mobileNo = request.getParameter("mobileno");
					String password = request.getParameter("password");
					System.out.println(firstName);
					System.out.println(lastName);
					System.out.println(userName);
					System.out.println(emailId);
					System.out.println(mobileNo);
					
					System.out.println(password);

						UserProfileService1.insert(userName,firstName,lastName,emailId,password,mobileNo);

						RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");
						rd.forward(request, response);
						
				}

			}


	}


