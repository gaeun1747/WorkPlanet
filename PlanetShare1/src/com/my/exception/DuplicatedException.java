package com.my.exception;

public class DuplicatedException extends InsertException {
	public DuplicatedException() {
		super();
	}
	public DuplicatedException(String message) {
		super(message);
	}

}
