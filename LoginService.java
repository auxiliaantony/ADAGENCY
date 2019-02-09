package com.adagency.online.serv;


import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.adagency.online.model.UserCredential;
import com.adagency.online.util.HBFactory;
import com.adagency.online.util.Utility;




public class LoginService {
	public static String validate(String emailid, String password) {
		System.out.println("username="+emailid);
		System.out.println("password="+password);
		String code = "";
		Session session = HBFactory.get().openSession();
		session.beginTransaction();
		UserCredential user = session.get(UserCredential.class, emailid);
		if (user != null && user.getPassword().equals(password)) {
			if (user.getAuthKey().isEmpty()) {
				code = Utility.generateKey(20);
				System.out.println("The Code is Generated" + code);
				user.setAuthKey(code);
				session.update(user);
			} else {
				System.out.println("already user name is logged in and auth key is present");
				System.out.println("kirukku"+code);
				code="";
			}
		}
		session.getTransaction().commit();
		session.close();
		return code;
	}
	public static boolean logout(HttpServletResponse response,String emailid,String code){
		boolean status = false;
		SessionFactory sf = new FactoryService().get();
		Session session = sf.openSession();
		session.beginTransaction();
		
		UserCredential user = session.get(UserCredential.class, emailid);
		System.out.println("user null:"+(user!=null) + "user Authkey:"+ (user.getAuthKey().equals(code)));
		System.out.println("key:"+user.getAuthKey()+"emailid:"+user.getEmailId()+"code:"+code);
		if(user!=null && user.getAuthKey().equals(code)){
			Cookie cookie = new Cookie("user_emailId","");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			cookie = new Cookie("user_key","");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			user.setAuthKey("");
			status = true;
			session.update(user);
		}
		session.getTransaction().commit();
		session.close();
		return status;
	}
		public static String findKey(String emailId){
			String key=null;
			SessionFactory sf = new FactoryService().get();
			Session session = sf.openSession();
			session.beginTransaction();
			
			String hql = "FROM UserCredential WHERE email_id=:email";
			Query query = session.createQuery(hql);
			query.setParameter("email", emailId);
			
			List<UserCredential> credential = query.getResultList();
			for(UserCredential var:credential){
				key = var.getAuthKey();
			}
			return key;
		}
	
	
}
