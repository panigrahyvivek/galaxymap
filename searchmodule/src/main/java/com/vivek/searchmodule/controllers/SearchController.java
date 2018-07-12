package com.vivek.searchmodule.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.searchmodule.models.Search;

@RestController
@RequestMapping("/searchcache")
public class SearchController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	public Object getAllSearchCache(){
		
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
