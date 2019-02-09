package com.adagency.online.model.sourcetype;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.adagency.online.model.info.AdDetails;

@Entity
@Table(name = "oaa_company", catalog = "oaadb")
@TableGenerator(name = "company_tab_gen", allocationSize = 1, initialValue = 0, catalog = "oaadb", table = "oaa_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "company_id_id")
public class Company {
	@Id
	@GeneratedValue(generator = "company_tab_gen", strategy = GenerationType.TABLE)
	@Column(name = "company_id")
	private int companyId;
	
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_number")
	private String phoneNumber;

	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ad_id")
	private AdDetails addetails;
	
	public AdDetails getAddetails() {
		return addetails;
	}

	public void setAddetails(AdDetails addetails) {
		this.addetails = addetails;
	}*/

	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ad_id")
	private AdDetails addetails;*/
	
	public String getPhoneNumber() {
		return phoneNumber;
}

	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "MailId")
	private String mailId;
	@Column(name = "branhes")
	private String branches;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getBranches() {
		return branches;
	}

	public void setBranches(String branches) {
		this.branches = branches;
	}

	
}
