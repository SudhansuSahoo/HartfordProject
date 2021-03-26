package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "view_case_client1")
public class ViewCaseClient1 implements Serializable{
	
	@Id
	@Column(name="SPNSRID")
	private String spnsrId;
	@Column(name="CASEID")
	private String caseId;
	
	public String getSpnsrId() {
		return spnsrId;
	}
	public void setSpnsrId(String spnsrId) {
		this.spnsrId = spnsrId;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
}
