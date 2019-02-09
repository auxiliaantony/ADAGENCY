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
import com.adagency.online.model.info.SourceType;
import com.adagency.online.util.HBFactory;




@WebServlet("/FetchMagazine")
public class FetchMagazine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FetchMagazine() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				try (PrintWriter out = response.getWriter()) {
					out.println("<html>");
					out.println("<head>");
					out.println("<link rel='stylesheet' href='css/bootstrap.css' />");
					out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");

					out.println("</head>");
					out.println("<body>");
					Session session = HBFactory.get().openSession();
					session.beginTransaction();
					String sel = "from Magazine";
					Query query = session.createQuery(sel);
					List<Magazine> magazine = query.getResultList();
					out.println("<table class ='table' >");
					out.println("<tr>");
					
					out.println("<th>");
					out.println("MAGAZINENAME");
					out.println("</th>");
					
					
					out.println("<th>");
					out.println("MAGZINESIZE");
					out.println("</th>");
					
					
					out.println("<th>");
					out.println("FROMDATE");
					out.println("</th>");
					
					
					out.println("<th>");
					out.println("PAGENO");
					out.println("</th>");
					
					
					out.println("<th>");
					out.println("TODATE");
					out.println("</th>");
					
					
					out.println("<th>");
					out.println("SOURCETYPE");
					out.println("</th>");
					out.println("</tr>");
					
					SourceType sourctype = SourceType.valueOf("PRODUCT");
					//out.println(sourctype+"is the category");
					//System.out.println(cat.compareTo(Category.WOMEN));
					for(Magazine m:magazine){
						if(m.getSourceType().compareTo(sourctype)==0){
						//if(s.getCategory().compareTo(cat)==0){
						out.println("<tr>"+"<td>" +m.getMagName()+"</td>"+"<td>"+m.getMagSize()+"</td>"+"<td>"+m.getToDate()+"</td>"+"<td>"+m.getPageNo()+"</td>"+"<td>"+m.getFromDate()+"</td>"+"<td>"+"</tr>");
						//out.println("<tr>"+"<td>" +m.getMagName()+"</td>"+"<td>"+m.getMagSize()+"</td>"+"<td>"+m.getToDate()+"</td>"+"<td>"+m.getPageNo()+"</td>"+"<td>"+m.getFromDate()+"</td>"+"<td>"+"<a href='export?id=" + s.getStockId() + "'>Export</a>"+"</td>"+"</td>"+"<td>"+"<a href='hire?id=" + s.getStockId() + "'>Hire</a>"+"</td>"+"</tr>");
						
						}
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
