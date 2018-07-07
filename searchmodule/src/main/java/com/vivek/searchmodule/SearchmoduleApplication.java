package com.vivek.searchmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SearchmoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchmoduleApplication.class, args);
	}
	
	@RestController
    @RequestMapping("hello")
    class HelloControllerWithParams {
        @GetMapping
        public String getMessage(@RequestParam(defaultValue = "Live Reload!") String name) {
            return "Hello " + name;
        }
    }
}