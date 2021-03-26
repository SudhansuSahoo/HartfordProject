package com.hig.oracleformsmigration.casemanagement.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaseID implements Serializable {
	
	@JsonProperty("caseID")
	private String caseId;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public CaseID(String caseId) {
		super();
		this.caseId = caseId;
	}

	public CaseID() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
