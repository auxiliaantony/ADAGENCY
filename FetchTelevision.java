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

import com.adagency.online.model.adtype.Magazine;
import com.adagency.online.model.adtype.Television;
import com.adagency.online.model.info.SourceType;
import com.adagency.online.util.HBFactory;


@WebServlet("/FetchTelevision")
public class FetchTelevision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FetchTelevision() {
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
			String sel = "from Television";
			Query query = session.createQuery(sel);
			List<Television> television = query.getResultList();
			out.println("<table class ='table' >");
			out.println("<tr>");
			
			out.println("<th>");
			out.println("TELEID");
			out.println("</th>");
			
			
			out.println("<th>");
			out.println("CHANNELNAME");
			out.println("</th>");
			
			
			
			out.println("<th>");
			out.println("FROMDATE");
			out.println("</th>");
			
			out.println("<th>");
			out.println("TODATE");
			out.println("</th>");
			
			out.println("<th>");
			out.println("DURATION");			
			out.println("</th>");
			
			
			out.println("<th>");			
			out.println("SOURCETYPE");
			out.println("</th>");
			
			out.println("</tr>");

		
			
			for(Television t:television){
				
				out.println("<tr>"+"<td>" +t.getTelId()+"</td>" +"<td>" +t.getChannelName()+"</td>" + "<td>"+t.getFromDate()+"</td>" + "<td>"+t.getToDate()+"</td>" + "<td>"+ t.getDuration()+"</td>"  + "<td>"+t.getSourceType()+"</td>"+"<tr>");
				
				}
			
			out.println("</table>");
			out.println(" <center> <a class='btn btn-primary' href='view.html'>Back</a> <center> ");
			out.println("</body>");
			out.println("</html>");
		
		
		
		}}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
