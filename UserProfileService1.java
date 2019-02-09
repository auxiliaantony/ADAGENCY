package com.adagency.online.serv;

import java.util.Set;

import org.hibernate.Session;


import com.adagency.online.model.UserCredential;
import com.adagency.online.model.UserProfile1;
import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.info.AdType;
import com.adagency.online.model.sourcetype.Company;
import com.adagency.online.util.HBFactory;

public class UserProfileService1 {
	
	
	public static UserProfile1 get(String firstname) {
		Session session = HBFactory.get().openSession();
	UserProfile1 company = session.get(UserProfile1.class,firstname);
		session.close();
		
		return company;

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
		
	}*/
		

		public static void insert(String userName,String firstName, String lastName, String mobileNo,String emailId,String password) {
			Session session =HBFactory.get().openSession();
			session.beginTransaction();
			/*CredentialService i = new CredentialService();
			System.out.println(emailId);
			System.out.println(mobileNo);
			
			System.out.println(password);
			i.create(emailId,password);*/
			UserCredential credential = new UserCredential();
			UserProfile1 userprofile = new UserProfile1();

			credential.setEmailId(emailId);
			credential.setPassword(password);
			credential.setActivated(false);
			credential.setAuthKey("");
			credential.setProfile1(userprofile);
			
			
			userprofile.setMobileNo(mobileNo);
			userprofile.setLastName(lastName);
			userprofile.setFirsttName(firstName);
			userprofile.setUserName(userName);
			userprofile.setCredential(credential);
			//credential.setProfile1(userprofile);
			session.save(credential);
			session.save(userprofile);
			session.getTransaction().commit();
			session.close();
		}
	
	

}
