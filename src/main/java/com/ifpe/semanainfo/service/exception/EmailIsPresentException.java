package com.ifpe.semanainfo.service.exception;

public class EmailIsPresentException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmailIsPresentException(String msg) {
		super(msg);
	}
}
