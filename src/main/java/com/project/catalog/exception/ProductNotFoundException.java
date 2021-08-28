package com.project.catalog.exception;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 969886303220027560L;
	
	@Autowired
	ErrorMessage errorMessage;
	 
	public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
    public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

}
