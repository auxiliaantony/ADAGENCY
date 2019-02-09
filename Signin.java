package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.serv.CredentialService;
import com.adagency.online.serv.CredentialStatus;
import com.adagency.online.serv.LoginService;


public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Signin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				response.setContentType("text/html");
				try (PrintWriter out = response.getWriter()) {
				String emailId = request.getParameter("e");
				String pass = request.getParameter("pa");
				CredentialService credential = new CredentialService();
				CredentialStatus status = credential.validate(emailId, pass);
				String key = LoginService.findKey(emailId);
				if (status.compareTo(CredentialStatus.NOT_ACTIVATED) == 0) {
					System.out.println("not activated block");
					credential.activate(emailId, LoginService.findKey(emailId));
					request.getRequestDispatcher("loginsign.html").include(request, response);
				} else if (status.compareTo(CredentialStatus.LOGGED) == 0) {
					System.out.println("logged block");
					request.getRequestDispatcher("login.html").include(request, response);
				} else if (status.compareTo(CredentialStatus.NOT_AVAILABLE) == 0) {
					System.out.println("not available block");
					request.getRequestDispatcher("sign.html").include(request, response);
				} else if (status.compareTo(CredentialStatus.SUCCESS) == 0) {
					System.out.println("successs block");
					request.getRequestDispatcher("login.html").include(request, response);
				} else if (status.compareTo(CredentialStatus.ERROR) == 0) {
					System.out.println("error block");
					request.getRequestDispatcher("sign.html").include(request, response);
				} else{
					out.println(status);
				}
				if(status.compareTo(CredentialStatus.NOT_ACTIVATED)==0 || status.compareTo(CredentialStatus.SUCCESS)==0 || 
						status.compareTo(CredentialStatus.LOGGED)==0){
					Cookie cookie = new Cookie("user_emailId",emailId);
					cookie.setMaxAge(24*60*60*7);
					response.addCookie(cookie);
					cookie = new Cookie("user_key",key);
					cookie.setMaxAge(24*60*60*7);
					response.addCookie(cookie);
					System.out.println(cookie+" "+emailId+" "+key);
				}
			}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
