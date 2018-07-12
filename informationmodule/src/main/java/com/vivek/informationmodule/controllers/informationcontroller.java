package com.vivek.informationmodule.controllers;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.informationmodule.models.information;
import com.vivek.informationmodule.repositories.informationrepository;

@RestController
@RequestMapping("/information")
public class informationcontroller{
	
	private static Logger log = LoggerFactory.getLogger(informationcontroller.class);
	
	@Autowired
	private informationrepository infojpa;
	
	@GetMapping(path="index")
	public Map getInformationIndexes() {
		
		List<information> list = infojpa.findAll();
		Map<String, information> listMap = list.stream()
		         .collect(Collectors.toMap(information::getId, Function.identity()));
		
		log.info("Logging information from information module");
		return listMap;
	}
}