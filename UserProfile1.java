package com.adagency.online.model;


	import java.io.Serializable;
	import java.util.Collection;
	import java.util.HashSet;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Embedded;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	//import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.JoinTable;
	import javax.persistence.OneToMany;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;
	import javax.persistence.TableGenerator;
	import javax.persistence.UniqueConstraint;

import com.adagency.online.model.info.AdDetails;


	@Entity
	@Table(name = "oaa_user_profile", catalog = "oaadb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "mobile_no", name = "oaa_user_profile_mobile_unq") })
	@TableGenerator(name = "prof_tab_gen", allocationSize = 1, initialValue = 1000, catalog = "oaadb", table = "prof_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "user_id")
public class UserProfile1 implements Serializable {

		@Id
		@Column(name = "user_id")
		@GeneratedValue(generator = "prof_tab_gen", strategy = GenerationType.TABLE)
		private int userId;
		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		private static final long serialVersionUID = 976295143483042584L;
		
		
		
		@Column(name = "user_name", nullable = false, length = 100)
		private String userName;
		
		
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		
		
		@Column(name = "first_name", nullable = false, length = 100)
		private String firsttName;
		
		
		public String getFirsttName() {
			return firsttName;
		}

		public void setFirsttName(String firsttName) {
			this.firsttName = firsttName;
		}

		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name= "email_id")
		private UserCredential credential;
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "oaa_user_addetails", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "ad_id"))
		private Collection<AdDetails> adType = new HashSet<AdDetails>();
		

		
		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		
		@Column(name = "last_name", nullable = false, length = 100)
		private String lastName;
		
		@Column(name = "mobile_no", nullable = false, length = 50)
		private String mobileNo;
		
		
		
		
		
		
		public String getLastName() {
			return lastName;
		}

		
		public Collection<AdDetails> getAdType() {
			return adType;
		}

		public void setAdType(Collection<AdDetails> adType) {
			this.adType = adType;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		
		
		public UserCredential getCredential() {
			return credential;
		}
		

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		

		public void setCredential(UserCredential credential) {
			this.credential = credential;
		}

	}


