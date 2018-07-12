package com.vivek.searchmodule.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
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
}
