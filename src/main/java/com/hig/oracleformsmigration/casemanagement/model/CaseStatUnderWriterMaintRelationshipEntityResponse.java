package com.hig.oracleformsmigration.casemanagement.model;

public class CaseStatUnderWriterMaintRelationshipEntityResponse {
	
	private String statUndrwrtr;
	private String name;
	
	public String getStatUndrwrtr() {
		return statUndrwrtr;
	}
	public void setStatUndrwrtr(String statUndrwrtr) {
		this.statUndrwrtr = statUndrwrtr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CaseStatUnderWriterMaintRelationshipEntityResponse(String statUndrwrtr, String name) {
		super();
		this.statUndrwrtr = statUndrwrtr;
		this.name = name;
	}
	public CaseStatUnderWriterMaintRelationshipEntityResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
