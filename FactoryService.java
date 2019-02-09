package com.adagency.online.serv;


import org.hibernate.SessionFactory;

import com.adagency.online.util.HBFactory;

public class FactoryService {
	protected SessionFactory factory;

	public FactoryService() {
		super();
		this.factory = HBFactory.get();
	}

	public SessionFactory get() {
		System.out.println("factory service");
		return factory;
	}

}

