package com.hig.oracleformsmigration.lossprocessing.model;

public class SponsorPolicyResponse {
	private String errorCode;
	private String errorMessage;
	private PolicyCursor policyCursor;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public PolicyCursor getPolicyCursor() {
		return policyCursor;
	}
	public void setPolicyCursor(PolicyCursor policyCursor) {
		this.policyCursor = policyCursor;
	}
	
	

}
