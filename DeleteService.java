package com.adagency.online.serv;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.adagency.online.util.HBFactory;
public class DeleteService {

			public static void deleteaddetails(Integer id){
				SessionFactory sf = new FactoryService().get();
				Session session = sf.openSession();
				session.beginTransaction();
				
				String hql = "delete from AdDetails  where ad_id = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id",id);
				query.executeUpdate();

				session.getTransaction().commit();
				session.close();
		}
			/*public static void delete1(Integer id){
				SessionFactory sf = new FactoryService().get();
				Session session = sf.openSession();
				session.beginTransaction();
				
				String hql = "delete from Flowers  where pid = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id",id);
				query.executeUpdate();

				session.getTransaction().commit();
				session.close();
		}
			public static void delete2(Integer id){
				SessionFactory sf = new FactoryService().get();
				Session session = sf.openSession();
				session.beginTransaction();
				
				String hql = "delete from Vegetables  where pid = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id",id);
				query.executeUpdate();

				session.getTransaction().commit();
				session.close();
		}
			public static void delete3(Integer id){
				SessionFactory sf = new FactoryService().get();
				Session session = sf.openSession();
				session.beginTransaction();
				
				String hql = "delete from Cart  where pid = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id",id);
				query.executeUpdate();

				session.getTransaction().commit();
				session.close();
		}
*/

	

}
