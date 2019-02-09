package com.adagency.online.serv;

import java.util.Date;

import org.hibernate.Session;

import com.adagency.online.model.adtype.NewsPaper;
import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.info.SourceType;
import com.adagency.online.util.HBFactory;

public class NewsPaperService{
	
public static NewsPaper get(String value) {
		
		Session session = HBFactory.get().openSession();
		NewsPaper newspaper = session.get(NewsPaper.class,value);
		session.close();
		return newspaper;

}
	
	public static void insert(String newspaperName, String pageNo, String adSize,String fromDate,String toDate,String sourceType) {
		Session session =HBFactory.get().openSession();
		session.beginTransaction();
		NewsPaper newspaper= new NewsPaper();
		newspaper.setAdSize(adSize);
		newspaper.setFromDate(fromDate);
		newspaper.setToDate(toDate);
		newspaper.setPageNo(pageNo);
		newspaper.setNewspaperName(newspaperName);
		AdDetails addetails=new AdDetails();
		//newspaper.setAddetails(addetails);
		
		if(sourceType.equals("product"))
		{
		newspaper.setSourceType(SourceType.PRODUCT);
		}
		
		else if(sourceType.equals("film"))
		{
		newspaper.setSourceType(SourceType.FILM);
		}
		else if(sourceType.equals("company"))
		{
			newspaper.setSourceType(SourceType.COMPANY);	
		}
		session.save(newspaper);
		session.getTransaction().commit();
		session.close();
	}
	

}
