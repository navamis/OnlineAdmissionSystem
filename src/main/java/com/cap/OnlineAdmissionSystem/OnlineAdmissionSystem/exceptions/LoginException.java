package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LoginException  extends RuntimeException{
	
	
	public LoginException() {
		
	}
	public LoginException(String message) {
		super(message);
	}

}
