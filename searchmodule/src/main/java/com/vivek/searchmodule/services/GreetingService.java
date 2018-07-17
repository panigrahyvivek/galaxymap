package com.vivek.searchmodule.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetingService{
	private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);
	
	
	public GreetingService() {

	}

	public void greet() {
		logger.info("Greeting from Vivek!!!");
	}
	
}