package com.project.catalog.exception;

import com.project.catalog.util.CatalogResponse;

public class CategoryNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3390888880988379213L;
	
	CatalogResponse catalogResponse;

	public CatalogResponse getCatalogResponse() {
		return catalogResponse;
	}

	public void setCatalogResponse(CatalogResponse catalogResponse) {
		this.catalogResponse = catalogResponse;
	} 
	
}
