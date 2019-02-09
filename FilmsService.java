package com.adagency.online.serv;

import java.util.Date;

import org.hibernate.Session;

import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.sourcetype.Films;
	
	import com.adagency.online.util.HBFactory;

	public class FilmsService{
		
	public static Films get(String value) {
			
			Session session = HBFactory.get().openSession();
			Films films = session.get(Films.class,value);
			session.close();
			return films;

	}
		
		public static void insert(String directorName, String filmName,String heroName,String musicDirector,String producer,Date releaseDate) {
			Session session =HBFactory.get().openSession();
			session.beginTransaction();
			Films films=new Films();
			films.setDirectorName(directorName);
			films.setFilmName(filmName);
			films.setHeroName(heroName);
			films.setMusicDirector(musicDirector);
			films.setProducer(producer);
			films.setReleaseDate(releaseDate);
			AdDetails addetails=new AdDetails();
			//films.setAddetails(addetails);
			session.save(films);
			session.getTransaction().commit();
			session.close();
		}

		
		
			
			

}
