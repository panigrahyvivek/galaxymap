package com.vivek.searchmodule.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vivek.searchmodule.models.Search;

@RestController
@RequestMapping("/searchcache")
public class SearchController {
	
	private static Logger log = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	public Object getAllSearchCache(){
		
		log.info("Logging information from search module");
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
		  = "http://localhost:9002/information/index";
		ResponseEntity<Map> response
		  = restTemplate.getForEntity(fooResourceUrl , Map.class);
		
		return jdbcTemplate.queryForList("select * from SEARCHCACHE");
		
	}
	
	@PostMapping
	public void updateSearchCache(@ModelAttribute @Validated Search search){
		
		UUID uuid = UUID.randomUUID();
		String text = search.getText();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		jdbcTemplate.update(
			    "INSERT INTO SEARCHCACHE (ID, TEXT, SEARCHDATE) VALUES (?, ?, ?)",
			    uuid, text, timestamp);
		
	}
}
