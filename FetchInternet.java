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
import com.adagency.online.model.adtype.Internet;
import com.adagency.online.model.adtype.Magazine;
import com.adagency.online.util.HBFactory;


@WebServlet("/fetchinternet")
public class FetchInternet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FetchInternet() {
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
			String sel = "from Internet";
			Query query = session.createQuery(sel);
			List<Internet> internet = query.getResultList();
			out.println("<table class ='table' >");
			out.println("<tr>");
			
			out.println("<th>");
			out.println("INTERNETID");
			out.println("</th>");
			
			
			out.println("<th>");
			out.println("WEBSITENAME");
			out.println("</th>");
			
			out.println("<th>");
			out.println("FROMDATE");
			out.println("</th>");
			
			out.println("<th>");
			out.println("TODATE");
			out.println("</th>");
			
			out.println("<th>");
			out.println("MEDIA");
			out.println("</th>");
			
			out.println("<th>");
			out.println("MEDIASIZE");
			out.println("</th>");
			
			out.println("<th>");
			out.println("SOURCETYPE");
			out.println("</th>");
			out.println("</tr>");

			

			
			for(Internet i:internet){
				
				out.println("<tr>"+"<td>" +i.getNetId()+"<td>" +i.getWebsiteName()+"</td>"+"<td>"+i.getFromDate()+"</td>"+"<td>"+i.getToDate()+"</td>"+"<td>"+i.getMedia()+"</td>"+"<td>"+i.getSize()+"</td>"+"<td>"+i.getSourceType()+"</td>"+"<td>");
				
				}
			
			out.println("</table>");
			out.println(" <center> <a class='btn btn-primary' href='view.html'>Back</a> <center> ");
			out.println("</body>");
			out.println("</html>");
			
			//request.getRequestDispatcher("magazine.html").include(request, response);
			//session.close();
			
			
			
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
