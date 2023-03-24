package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DaikichiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiApplication.class, args);
	}

	@RequestMapping("/daikichi/travel/Honolulu")
	public String HonoluluGreeting() {
		return "Congratulation! You will soon travel to Honolulu";
	}
	
	@RequestMapping ("/daikichi/lotto/6")
	public String daikichiLoto() {
		return " You will take a grand journey in the future, but be wary of tempting offers";
	}
	
	@RequestMapping ("/daikichi/travel/{location}")
	public String customTravel (@PathVariable("location") String local) {
		return "Congratulation! You will soon travel to " + local ;
	}
	
	
	@RequestMapping ("/daikichi/loto/{lotonumber}")
	public String customTravel (@PathVariable("lotonumber") int lotonum) {
		return "Congratulation! You will soon travel to " + lotonum ;
	}
	
}
