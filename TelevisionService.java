package com.adagency.online.serv;

import java.util.Date;

import org.hibernate.Session;

import com.adagency.online.model.adtype.Television;
import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.info.SourceType;
import com.adagency.online.util.HBFactory;

public class TelevisionService {

	public static Television get(String value) {

		Session session = HBFactory.get().openSession();
		Television television = session.get(Television.class, value);
		session.close();
		return television;

	}

	public static void insert(String channelName, String duration, String fromDate, String toDate, String sourceType) {
		Session session = HBFactory.get().openSession();
		session.beginTransaction();
		Television television = new Television();
		television.setChannelName(channelName);
		television.setDuration(duration);
		television.setFromDate(fromDate);
		television.setToDate(toDate);
		AdDetails addetails=new AdDetails();
		//television.setAddetails(addetails);
		

		if (sourceType.equals("product")) {

			television.setSourceType(SourceType.PRODUCT);
		}

		else if (sourceType.equals("film")) {
			television.setSourceType(SourceType.FILM);
		} else if (sourceType.equals("company")) {
			television.setSourceType(SourceType.COMPANY);
		}

		session.save(television);
		session.getTransaction().commit();
		session.close();
	}
}