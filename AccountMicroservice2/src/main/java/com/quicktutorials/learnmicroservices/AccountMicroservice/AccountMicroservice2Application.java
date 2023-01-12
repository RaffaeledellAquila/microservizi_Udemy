package com.quicktutorials.learnmicroservices.AccountMicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication		//CommandLineRunner - permette di effettuare operazioni prima che l'applicazione si avviera
public class AccountMicroservice2Application  implements CommandLineRunner{

	
    //serve a farci stampare info sull'esecuzione dell'app
	private static final Logger log = LoggerFactory.getLogger(AccountMicroservice2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(AccountMicroservice2Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		//questo metodo e' dell'interfaccia CommandLineRunner
		// tutto quello che viene specificato in questo metodo avverra prima dell'applicazione
		
		log.info("metodo run");
	}

}
