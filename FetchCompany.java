package com.adagency.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.adagency.online.model.sourcetype.Company;
import com.adagency.online.util.HBFactory;

@WebServlet("/fetchcompany")
public class FetchCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FetchCompany() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel='stylesheet' href='css/bootstrap.css' />");
			out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");
			
			out.println("</head>");
			out.println("<body>");
			Session session = HBFactory.get().openSession();
			session.beginTransaction();
			String sel = "from Company";
			Query query = session.createQuery(sel);
			List<Company> company = query.getResultList();
			out.println("<table class='table'>");
			out.println("<tr>");
			
			out.println("<th scope='col'>");
			out.println("COMPANYID");
			out.println("</th>");
			
			
			out.println("<th scope='col'>");
			out.println("COMPNAYNAME");
			out.println("</th>");
			
			
			
			out.println("<th scope='col'>");
			out.println("MAILID");
			out.println("</th>");
			
			out.println("<th scope='col'>");
			out.println("ADDRESS");
			out.println("</th>");
			
			out.println("<th scope='col'>");
			out.println("PHONENUMBER");			
			out.println("</th>");
			
			
			out.println("<th scope='col'>");
			out.println("BRANCH");			
			out.println("</th>");
			
			
			
			out.println("</tr>");

		
			
			for(Company i:company){
				
				out.println("<tr>"+"<td>" +i.getCompanyId()+"<td>" +i.getCompanyName()+"</td>"+"<td>"+i.getMailId()+"</td>"+"<td>"+i.getAddress()+"</td>"+"<td>"+i.getPhoneNumber()+"</td>"+"<td>"+i.getBranches()+"</td>"+"</tr>");
				
				}
			
			out.println("</table>");
			out.println(" <center> <a class='btn btn-primary' href='view.html'>Back</a> <center> ");
			out.println("</body>");
			out.println("</html>");
		
		
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
