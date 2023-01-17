package com.quicktutorials.learnmicroservices.AccountMicroservice.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.quicktutorials.learnmicroservices.AccountMicroservice.entities.User;

@Controller
public class RestController {

	 @RequestMapping("/hello")
	 @ResponseBody//N.B.------ indica che la stringa restituita sara' direttamente il corpo del messaggio
	    public String sayHello(){
	        return "Hello everyone!";
	    }
	//if pwd is null it will still return a user
	    @RequestMapping("/newuser1")
	    @ResponseBody
	    public String addUser(User user){
	        return "Utente aggiunto correttamente:" + user.getId() + ", "+ user.getUsername();
	    }
	    
	    
	    
	  //aggiungendo @Valid davanti al parametro passato, verranno considerate le annotation di validazione dentro User
	   //se non rispettate le annotation di validazione restituisce un errore generico 400
	    @RequestMapping("/newuser2")
	    @ResponseBody
	    public String addUserValid(@Valid User user){
	        return "Utente aggiunto correttamente:" + user.getId() + ", "+ user.getUsername();
	    }

	    //aggiugendo BindingResult possiamo farci restituire in caso di errore il tipo di errore
	    @RequestMapping("/newuser3")
	    @ResponseBody
	    public String addUserValidPlusBinding(@Valid User user, BindingResult result){
	        if(result.hasErrors()){
	        	//return result.getFieldError().getCode().toString();
	            return result.toString();
	        }
	        return "Utente aggiunto correttamente:" + user.getId() + ", "+ user.getUsername();
	    }

	    //Con BindingResult possiamo personalizzare i conrtrolli di validazione Quindi non utilizzando @Valid
	    @RequestMapping("/newuser4")
	    @ResponseBody
	    public String addUserValidPlusBinding2(User user, BindingResult result){
	        
	    	//dopo aver creato la classe "UserValidator" che implementa l'interfaccia "Validator"
	    	/* Spring validation */
	        UserValidator userValidator = new UserValidator();
	        userValidator.validate(user, result);

	        if(result.hasErrors()){
	            return result.getFieldError().getCode().toString();
	        }
	        return "User added correctly:" + user.getId() + ", "+ user.getUsername();
	    }


	    /*-------------------------CLASSE PER PERSONALIZZARE GLI ERRORI-------------------*/
	    /*---------------------------INNER CLASS------------------------*/
	    //Spring Validator Example
	    private class UserValidator implements Validator {

	     
	    	// override del metodo validate con cui possiamo fare tutti i controlli che vogliamo sull'oggetto che vogliamo
	    	// in questo caso user
	        @Override
	        public void validate(Object obj, Errors errors) {
	            User user = (User) obj;
	            if (user.getPassword().length() < 8) {
	                errors.rejectValue("password", "the password must be at least 8 chars long!");
	            }
	            
	            if (user.getPassword().equalsIgnoreCase("password") ) {
	                errors.rejectValue("password", "la password non puo essere password");
	            }
	            
	            if (user.getUsername().length() <=2  ) {
	                errors.rejectValue("username", "username non puo essere meno di 2 caratteri");
	            }
	        }
	        
            //metodo obbligatorio per via dell'interfaccia Validator
			@Override
			public boolean supports(Class<?> clazz) {
				// TODO Auto-generated method stub
				return false;
			}
	    }
	    /*---------------------------------------------------------*/    

}
