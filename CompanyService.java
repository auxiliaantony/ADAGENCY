package com.adagency.online.serv;

	import org.hibernate.Session;

import com.adagency.online.model.info.AdDetails;
import com.adagency.online.model.sourcetype.Company;
	
	import com.adagency.online.util.HBFactory;

	public class CompanyService{
		
	public static Company get(String value) {
			
			Session session = HBFactory.get().openSession();
			Company company = session.get(Company.class,value);
			session.close();
			return company;

	}
		
		public static void insert(String address, String branches,String companyName,String mailId,String phoneNumber) {
			Session session =HBFactory.get().openSession();
			session.beginTransaction();
			Company company=new Company();
			company.setAddress(address);
			company.setBranches(branches);
			company.setCompanyName(companyName);
			company.setMailId(mailId);
			company.setPhoneNumber(phoneNumber);
			AdDetails addetails=new AdDetails();
			//company.setAddetails(addetails);
			session.save(company);
			session.getTransaction().commit();
			session.close();
		}

		
		
			
			
		

}
