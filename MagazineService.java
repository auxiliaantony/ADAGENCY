package com.adagency.online.serv;

import java.util.Date;

import org.hibernate.Session;


import com.adagency.online.model.adtype.Magazine;
import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.info.SourceType;
import com.adagency.online.util.HBFactory;

public class MagazineService {
	
	public static Magazine get(String value) {
		
		Session session = HBFactory.get().openSession();
		Magazine magazine = session.get(Magazine.class,value);
		session.close();
		return magazine;

}
	
	public static void insert(String magName, String pageNo, String magSize,String fromDate,String toDate,String sourceType) {
		Session session =HBFactory.get().openSession();
		session.beginTransaction();
		AdDetails addetails=new AdDetails();
		Magazine magazine = new Magazine();
		magazine.setFromDate(fromDate);
		magazine.setToDate(toDate);
		magazine.setMagName(magName);
		magazine.setMagSize(magSize);
		magazine.setPageNo(pageNo);
		//magazine.setAddetails(addetails);
		
		
		if(sourceType.equals("product"))
		{
		magazine.setSourceType(SourceType.PRODUCT);
		}
		
		else if(sourceType.equals("film"))
		{
		magazine.setSourceType(SourceType.FILM);
		}
		else if(sourceType.equals("company"))
		{
			magazine.setSourceType(SourceType.COMPANY);	
		}

		session.save(magazine);
		session.getTransaction().commit();
		session.close();
	}




}
