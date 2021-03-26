package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table
public class CaseStatusCode {
	@Id
	@Column(name="STTSCD")
	private String sttscd;
	@Column(name="DSCRPTN")
	private String dscrptn;
	public String getSttscd() {
		return sttscd;
	}
	public void setSttscd(String sttscd) {
		this.sttscd = sttscd;
	}
	public String getDscrptn() {
		return dscrptn;
	}
	public void setDscrptn(String dscrptn) {
		this.dscrptn = dscrptn;
	}
	public CaseStatusCode(String sttscd, String dscrptn) {
		super();
		this.sttscd = sttscd;
		this.dscrptn = dscrptn;
	}
	public CaseStatusCode() {
		super();
		// TODO Auto-generated constructor stub
	}

}
