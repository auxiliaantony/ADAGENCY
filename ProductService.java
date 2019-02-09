package com.adagency.online.serv;

import java.util.Date;

import org.hibernate.Session;

import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.sourcetype.Films;
import com.adagency.online.model.sourcetype.Product;
import com.adagency.online.util.HBFactory;

public class ProductService {
	public static Product get(String value) {
		
		Session session = HBFactory.get().openSession();
		Product product = session.get(Product.class,value);
		session.close();
		return product;

}
	
	public static void insert(String productName, String offer,String price,String warranty,String features) {
		Session session =HBFactory.get().openSession();
		session.beginTransaction();
		Product product =new Product(); 
		product.setFeatures(features);
		product.setOffer(offer);
		product.setPrice(price);
		product.setProductName(productName);
		product.setWarranty(warranty);
		AdDetails addetails=new AdDetails();
		//product.setAddetails(addetails);
		session.save(product);
		session.getTransaction().commit();
		session.close();
	}

}
