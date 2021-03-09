package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities.Login;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.services.IUserService;

@RestController
public class LoginController {
	
	@Autowired
	IUserService  loginService;
	

@PostMapping("/login")
@ResponseStatus(code = HttpStatus.CREATED) 
public void addLoginDetails(@RequestBody Login login) {
	loginService.addLoginDetails(login);
	}

@GetMapping("/login")
@ResponseStatus(code = HttpStatus.OK)
public ArrayList<Login> getAllLoginDetails(){
	return (ArrayList<Login>) loginService.getAllLoginDetails();
	}


@GetMapping("/login/{userId}")
@ResponseStatus(code = HttpStatus.OK)
public Login getLoginDetailsById(@PathVariable int userId) {
	return loginService.getLoginDetailsById(userId);
	}

@DeleteMapping("/login/{userId}")
@ResponseStatus(code = HttpStatus.OK)
public void deleteLoginDetailsById(@PathVariable int userId) {
	loginService.deleteLoginDetailsById(userId);
	//loginService.deleteLoginById(userId);
	}


@PutMapping("/login/changePassword") 
@ResponseStatus(code = HttpStatus.OK)
public Login changePassword(@RequestBody Login password){
	loginService.changePassword(password);
	return password;  
	}


	
@PutMapping("/login/resetPassword")
@ResponseStatus(code = HttpStatus.OK)
public Login resetPassword(@RequestBody Login password) {
	loginService.resetPassword(password);
	return password; 
    }

}
	


