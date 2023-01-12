package com.quicktutorials.learnmicroservices.AccountMicroservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

	 @RequestMapping("/hello")
	 @ResponseBody//indica che la stringa restituita sara' direttamente il corpo del messaggio
	    public String sayHello(){
	        return "Hello everyone!";
	    }
	
}
