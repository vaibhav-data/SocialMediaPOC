package com.vaibhav.server.main.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vaibhav.server.main.exceptions.ExceptionBean;
import com.vaibhav.server.main.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		
		ExceptionBean exception = new ExceptionBean(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exception,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(UserNotFoundException ex, WebRequest request) {
		
		ExceptionBean exception = new ExceptionBean(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exception,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
