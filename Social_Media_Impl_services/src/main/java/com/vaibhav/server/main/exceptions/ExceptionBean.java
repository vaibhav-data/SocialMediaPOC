package com.vaibhav.server.main.exceptions;

import java.util.Date;

public class ExceptionBean {
	Date timestamp;
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getError() {
		return error;
	}
	String message;
	String error;
	public ExceptionBean(Date timestamp, String message, String error) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.error = error;
	}
}
