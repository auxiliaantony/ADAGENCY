package com.adagency.online.serv;


public class SigninStatus {
	public static void check(String emailId,String pass) {
	CredentialService i = new CredentialService();
	CredentialStatus name = i.validate(emailId,pass);
	CredentialStatus statusnow ;
	System.out.println("Password:          "+name);
	if(name == CredentialStatus.NOT_AVAILABLE)
	{
		statusnow = CredentialStatus.NOT_AVAILABLE;
	}
	else if(name == CredentialStatus.NOT_ACTIVATED)
	{
		statusnow = CredentialStatus.NOT_ACTIVATED;
	}
	else if(name == CredentialStatus.SUCCESS)
	{
		statusnow = CredentialStatus.SUCCESS;
	}
	else if(name == CredentialStatus.LOGGED)
	{
		statusnow = CredentialStatus.LOGGED;
	}
	}
}

