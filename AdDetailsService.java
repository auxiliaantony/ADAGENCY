package com.adagency.online.serv;


import org.hibernate.Session;

import com.adagency.online.model.UserCredential;
import com.adagency.online.model.UserProfile1;
import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.info.AdType;
import com.adagency.online.model.info.Budjet;
import com.adagency.online.model.info.SourceType;
import com.adagency.online.util.HBFactory;

public class AdDetailsService {
	
public static AdDetails get(String value) {
		
		Session session = HBFactory.get().openSession();
		AdDetails addetails = session.get(AdDetails.class,value);
		session.close();
		return addetails;

}
	
	public static void insert(String adType, String budjet) {
		Session session =HBFactory.get().openSession();
		session.beginTransaction();
		UserCredential usercredential=new UserCredential();
		
		AdDetails ad=new AdDetails();
	   // ad.setUserprofile(userprofile);
		
		if(adType.equals("magazine"))
		{
		ad.setAdType(AdType.MAGAZINE);
		if(budjet.equals("high"))
		{
			ad.setBudjet(Budjet.HIGH);
		}
		else if(budjet.equals("low"))
		{
			ad.setBudjet(Budjet.LOW);
		}
		else
		{
			ad.setBudjet(Budjet.MEDIUM);
		}
		}
		else if(adType.equals("television"))
		{
		ad.setAdType(AdType.TELEVISION);
		if(budjet.equals("high"))
		{
			ad.setBudjet(Budjet.HIGH);
		}
		else if(budjet.equals("low"))
		{
			ad.setBudjet(Budjet.LOW);
		}
		else
		{
			ad.setBudjet(Budjet.MEDIUM);
		}
		}
		else if(adType.equals("newspaper"))
		{
		ad.setAdType(AdType.NEWSPAPER);
		if(budjet.equals("high"))
		{
			ad.setBudjet(Budjet.HIGH);
		}
		else if(budjet.equals("low"))
		{
			ad.setBudjet(Budjet.LOW);
		}
		else
		{
			ad.setBudjet(Budjet.MEDIUM);
		}
		}
		else if(adType.equals("internet"))
		{
		ad.setAdType(AdType.INTERNET);
		if(budjet.equals("high"))
		{
			ad.setBudjet(Budjet.HIGH);
		}
		else if(budjet.equals("low"))
		{
			ad.setBudjet(Budjet.LOW);
		}
		else
		{
			ad.setBudjet(Budjet.MEDIUM);
		}
		}
		
		session.save(ad);
		//Budjet b=Budjet.valueOf(budjet);
		//session.save(b);
		session.getTransaction().commit();
		session.close();
	}

	
	
		
		
	

	}



