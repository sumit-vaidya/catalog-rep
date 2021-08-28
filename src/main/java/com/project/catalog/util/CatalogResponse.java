package com.project.catalog.util;

import org.springframework.http.HttpStatus;

public class CatalogResponse {

	private HttpStatus status;
	private String errorMsg;
	private CatalogErrorCode errorCode;
	private String referenceId;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public CatalogErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(CatalogErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
}
