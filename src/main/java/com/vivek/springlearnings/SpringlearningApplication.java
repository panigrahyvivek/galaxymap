package com.vivek.springlearnings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringlearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringlearningApplication.class, args);
	}
	
	/*@RestController
    @RequestMapping("/")
    class HelloController {
        @GetMapping
        public String getMessage() {
            return "Hello World!!";
        }
    }*/
	
	
	@RestController
    @RequestMapping("hello")
    class HelloControllerWithParams {
        @GetMapping
        public String getMessage(@RequestParam(defaultValue = "Hugo") String name) {
            return "Hello " + name;
        }
    }
}
