package com.quicktutorials.learnmicroservices.AccountMicroservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quicktutorials.learnmicroservices.AccountMicroservice.entities.User;

@Controller
public class RestController {

	 @RequestMapping("/hello")
	 @ResponseBody//indica che la stringa restituita sara' direttamente il corpo del messaggio
	    public String sayHello(){
	        return "Hello everyone!";
	    }
	//if pwd is null it will still return a user
	    @RequestMapping("/newuser1")
	    @ResponseBody
	    public String addUser(User user){
	        return "User added correctly:" + user.getId() + ", "+ user.getUsername();
	    }

}
