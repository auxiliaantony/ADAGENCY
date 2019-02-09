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
import com.adagency.online.model.sourcetype.Films;
import com.adagency.online.util.HBFactory;

@WebServlet("/FetchFilm")
public class FetchFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FetchFilm() {
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
			String sel = "from Films";
			Query query = session.createQuery(sel);
			List<Films> film = query.getResultList();
			out.println("<table class ='table' >");
			out.println("<tr>");
			
			out.println("<th>");
			out.println("FILMID");
			out.println("</th>");
			
			out.println("<th>");
			out.println("DIRECTORNAME");
			out.println("</th>");
			
			
			
			out.println("<th>");
			out.println("FILMNAME");
			out.println("</th>");
			
			out.println("<th>");
			out.println("HERONAME");
			out.println("</th>");
			
			out.println("<th>");
			out.println("PRODUCER");			
			out.println("</th>");
			
			
			out.println("<th>");
			out.println("MUSICIRECTOR");			
			out.println("</th>");
			
			
			out.println("<th>");
			out.println("RELEASEDATE");
			out.println("</th>");
			out.println("</tr>");

		
			
			for(Films f:film){
				
				out.println("<tr>"+"<td>" +f.getFilmId()+"<td>" +f.getDirectorName()+"</td>"+"<td>"+f.getFilmName()+"</td>"+"<td>"+f.getHeroName()+"</td>"+"<td>"+f.getProducer()+"</td>"+"<td>"+f.getMusicDirector()+"</td>"+"<td>"+f.getReleaseDate()+"</td>"+"</tr>");
				
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
