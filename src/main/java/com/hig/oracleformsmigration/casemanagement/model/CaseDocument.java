package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CASEDOCUMENT")
public class CaseDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CDID")
	private int cdid;
	@Column(name="CASEID")
	private int caseID;
	
	@Column(name="CMDID")
	private int cmdid;
	
	public int getCmdid() {
		return cmdid;
	}
	public void setCmdid(int cmdid) {
		this.cmdid = cmdid;
	}
	
	public int getCdid() {
		return cdid;
	}
	public void setCdid(int cdid) {
		this.cdid = cdid;
	}
	public int getCaseID() {
		return caseID;
	}
	public void setCaseID(int caseID) {
		this.caseID = caseID;
	}
	public CaseDocument(int cdid, int caseID, int cmdid) {
		super();
		this.cdid = cdid;
		this.caseID = caseID;
		this.cmdid = cmdid;
	}
	public CaseDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
