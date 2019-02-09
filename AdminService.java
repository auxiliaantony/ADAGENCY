package com.adagency.online.serv;

import java.util.Set;

import org.hibernate.Session;

import com.adagency.online.model.Admin;
import com.adagency.online.model.UserCredential;
import com.adagency.online.model.UserProfile1;
import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.info.AdType;
import com.adagency.online.model.sourcetype.Company;
import com.adagency.online.util.HBFactory;

public class AdminService {
	
	
	public static Admin get(String firstname) {
		Session session = HBFactory.get().openSession();
	Admin admin = session.get(Admin.class,firstname);
		session.close();
		
		return admin;

}

	/*public boolean availability(String emailId) {
		Session session = HBFactory.get().openSession();;
		boolean status = false;

		UserCredential credential = session.get(UserCredential.class, emailId);
		if (credential != null) {
			status = true;
		}

		session.close();
		return status;
	}

	public static String validate(String emailId){
		Session session = HBFactory.get().openSession();
		session.beginTransaction();
		System.out.println("hi");
		UserCredential credential = session.get(UserCredential.class,emailId);
		System.out.println("hello");
		System.out.println(credential);
		System.out.println("service password"+credential.getPassword());
		return credential.getPassword();
		
	}
		

		public static void insert(String firstName, String lastName, String mobileNo,String emailId,String password) {
			Session session =HBFactory.get().openSession();
			session.beginTransaction();
			UserCredential credential=new UserCredential();
			credential.setEmailId(emailId);
			credential.setPassword(password);
			UserProfile userprofile = new UserProfile();
			userprofile.setMobileNo(mobileNo);
			userprofile.setLastName(lastName);
			userprofile.setFirstName(firstName);
			userprofile.setPassword(password);
			userprofile.setCredential(credential);
			session.save(userprofile);
			session.getTransaction().commit();
			session.close();
		}
	*/
	

}
