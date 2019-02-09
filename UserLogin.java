package com.adagency.online.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adagency.online.serv.LoginService;
import com.adagency.online.util.Utility;


@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserLogin() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
				response.getWriter();
				String emailId = Utility.getCookieValue(request,"auth_user");
				String code = Utility.getCookieValue(request, "auth_key");
				System.out.println(emailId+" "+code);
				boolean status = LoginService.logout(response,emailId,code);
				response.setContentType("text/html");
				if(status){
					request.getRequestDispatcher("").include(request, response);
				}
				

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
