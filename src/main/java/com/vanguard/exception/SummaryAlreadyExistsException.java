package com.vanguard.exception;

public class SummaryAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	public SummaryAlreadyExistsException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return errorMessage;
	}

}
