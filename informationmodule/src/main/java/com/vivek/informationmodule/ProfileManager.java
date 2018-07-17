package com.vivek.informationmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ProfileManager{
	
	@Autowired
	Environment env;
	
	public void getActiveProfiles(){
		for(final String profileName: env.getActiveProfiles()) {
			System.out.println("Current Active Profile: " + profileName);
		}
	}
}