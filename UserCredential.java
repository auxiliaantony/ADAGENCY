package com.adagency.online.model;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@SuppressWarnings("deprecation")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "oaa_user_credential", catalog = "oaadb")
public class UserCredential implements Serializable {

	private static final long serialVersionUID = 7496270742065252760L;

	@Id
	@Column(name = "email_id", nullable = false)
	private String emailId;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "auth_key", length = 30, nullable = false)
	
	//@Column(name = "auth_key", length = 30)
	private String authKey;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	//@Column(name = "status")
	@Column(name = "status", nullable = false)
	private Boolean activated;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "credential")
	private UserProfile1 profile;


	public String getEmailId() {
		return emailId;
	}

	
	public String getPassword() {
		return password;
	}

	
	public String getAuthKey() {
		return authKey;
	}


	public Boolean getActivated() {
		return activated;
	}

	

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public void setProfile1(UserProfile1 profile) {
		this.profile = profile;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	
	
	public UserProfile1 getProfile1() {
		return profile;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
