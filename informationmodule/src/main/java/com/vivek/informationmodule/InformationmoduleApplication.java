package com.vivek.informationmodule;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.informationmodule.models.information;
import com.vivek.informationmodule.repositories.informationrepository;

@SpringBootApplication
public class InformationmoduleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(InformationmoduleApplication.class, args);
	}
	
	@Autowired
	informationrepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new information("1","blog","https://www.google.com"));
		
	}
	
	
	
}
