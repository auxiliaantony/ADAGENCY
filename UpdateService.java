package com.adagency.online.serv;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.adagency.online.model.info.AdType;
import com.adagency.online.model.info.Budjet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;

public class UpdateService {
	

				
				public static void update(Integer id,String adType, String budjet){
					SessionFactory sf = new FactoryService().get();
					Session session = sf.openSession();
					session.beginTransaction();
					
					String hql = "update AdDetails set budjet= :budjet where ad_id = :id";
					//String hql = "update AdDetails set budjet= :budjet,ad_type= :adType where ad_id = :id";
	
					Query query = session.createQuery(hql);
					//AdType a=AdType.valueOf(adType);
					//adType=adType.toUpperCase();
					budjet=budjet.toUpperCase();
					//AdType a=AdType.valueOf(adType);
					Budjet b= Budjet.valueOf(budjet);
			
					query.setParameter("budjet",b);
					query.setParameter("id",id);
					//query.setParameter("adType",a);
				  
					query.executeUpdate();
					


					session.getTransaction().commit();
					session.close();
			}
				/*public static void updatecompany(String address, String branches,String companyName,String mailId,String phoneNumber){
					SessionFactory sf = new FactoryService().get();
					Session session = sf.openSession();
					session.beginTransaction();
					
					String hql = "update  set brands = :brands,name =:name where pid = :id";
					//String hql1 = "updat Company  Fruits set brands = :brands,name =:name where pid = :id";
					Query query = session.createQuery(hql);
					//Query query1 = session.createQuery(hql1);
					query.setParameter("name",name);
					query.setParameter("brands",brands);
					query.setParameter("id",id);
					//query1.setParameter("name",name);
					//query1.setParameter("brands",brands);
					//query1.setParameter("id",id);
					query.executeUpdate();

					session.getTransaction().commit();
					session.close();
			}
				public static void updateveg(String name,Integer id,String brands,String category,String variety){
					SessionFactory sf = new FactoryService().get();
					Session session = sf.openSession();
					session.beginTransaction();
					
					String hql = "update Item set brands = :brands,name =:name where pid = :id";
					//String hql1 = "update Vegetables set brands = :brands,name =:name where pid = :id";
					Query query = session.createQuery(hql);
					//Query query1 = session.createQuery(hql1);
					query.setParameter("name",name);
					query.setParameter("brands",brands);
					query.setParameter("id",id);
					//query1.setParameter("name",name);
					//query1.setParameter("brands",brands);
					//query1.setParameter("id",id);
					query.executeUpdate();

					session.getTransaction().commit();
					session.close();
			}*/

	}


