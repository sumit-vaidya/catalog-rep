package com.project.catalog.exception;

import com.project.catalog.util.CatalogResponse;

public class ProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 969886303220027560L;
	
	CatalogResponse catalogResponse;

	public CatalogResponse getCatalogResponse() {
		return catalogResponse;
	}

	public void setCatalogResponse(CatalogResponse catalogResponse) {
		this.catalogResponse = catalogResponse;
	}	
}
