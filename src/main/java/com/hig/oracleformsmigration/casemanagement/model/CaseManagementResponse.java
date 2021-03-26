package com.hig.oracleformsmigration.casemanagement.model;


public class CaseManagementResponse {
	
	

	public CaseManagementResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaseManagementResponse(String message, String statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	private String message;
	private String statusCode;
}
