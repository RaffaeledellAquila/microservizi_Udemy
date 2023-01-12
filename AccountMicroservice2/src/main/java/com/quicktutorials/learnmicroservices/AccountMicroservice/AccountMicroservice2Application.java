package com.quicktutorials.learnmicroservices.AccountMicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountMicroservice2Application {

	
    //serve a farci stampare info sull'esecuzione dell'app
	private static final Logger log = LoggerFactory.getLogger(AccountMicroservice2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(AccountMicroservice2Application.class, args);
		
	}

}
