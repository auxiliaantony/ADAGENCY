package com.adagency.online.serv;

import org.hibernate.Session;

import com.adagency.online.model.info.Onlinecredit;
import com.adagency.online.util.HBFactory;

public class OnlineCreditService {
	public static Onlinecredit get(String value) {
		
		Session session = HBFactory.get().openSession();
		Onlinecredit credit = session.get(Onlinecredit.class,value);
		session.close();
		return credit;

}
	
	public static void insert(String owner, String cvv,String expirationDate,String cardNo) {
		Session session =HBFactory.get().openSession();
		session.beginTransaction();
		Onlinecredit credit=new Onlinecredit();
		credit.setOwner(owner);
		credit.setCvv(cvv);
		credit.setExpirationDate(expirationDate);
		credit.setCardNumber(cardNo);
		session.save(credit);
		session.getTransaction().commit();
		session.close();
	}

	
	
		
		
	

}
