package com.adagency.online.serv;

import java.util.Date;

import org.hibernate.Session;

import com.adagency.online.model.adtype.Internet;
import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.info.SourceType;
import com.adagency.online.util.HBFactory;

public class InternetService {
	
public static Internet get(String value) {
		
		Session session = HBFactory.get().openSession();
		Internet internet = session.get(Internet.class,value);
		session.close();
		return internet;

}
	
	public static void insert(String websiteName, String media,String size,String fromDate,String toDate,String sourceType) {
		Session session =HBFactory.get().openSession();
		session.beginTransaction();
		Internet internet = new Internet();
		internet.setFromDate(fromDate);
		internet.setToDate(toDate);
		internet.setMedia(media);
		internet.setSize(size);
		internet.setWebsiteName(websiteName);
	//AdDetails addetails=new AdDetails();
		//internet.setAddetails(addetails);
		System.out.println("SOURCTYPE"+sourceType);
		if(sourceType.equals("product"))
		{
			

			internet.setSourceType(SourceType.PRODUCT);
			System.out.println("hi");
		
		}
		
		else if(sourceType.equals("film"))
		{
			internet.setSourceType(SourceType.FILM);
		}
		else if(sourceType.equals("company"))
		{
			internet.setSourceType(SourceType.COMPANY);	
		}
		session.save(internet);
		session.getTransaction().commit();
		session.close();
	}

	
	
		
		
	

	}


