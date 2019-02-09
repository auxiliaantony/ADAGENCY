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

import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.sourcetype.Films;
import com.adagency.online.util.HBFactory;


@WebServlet("/fetch")
public class FetchAddetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public FetchAddetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel='stylesheet' href='css/bootstrap.css' />");
			out.println("</head>");
			out.println("<body>");
			Session session = HBFactory.get().openSession();
			session.beginTransaction();
			String sel = "from AdDetails";
			Query query = session.createQuery(sel);
			List<AdDetails> addetails = query.getResultList();
			out.println("<table border=1>");
			out.println("<tr>");
			
			out.println("<th>");
			out.println("ADID");
			out.println("</th>");
			
			
			
			out.println("<th>");
			out.println("ADTYPE");
			out.println("</th>");
			
			out.println("<th>");
			out.println("BUDJET");
			out.println("</th>");
			
			
		
			
			for(AdDetails f:addetails){
				
				out.println("<tr>"+"<td>" +f.getAdId()+"</td>"+"<td>"+f.getAdType()+"</td>"+"<td>"+f.getBudjet()+"</td>"+"</tr>");
				
				}
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		
		
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
