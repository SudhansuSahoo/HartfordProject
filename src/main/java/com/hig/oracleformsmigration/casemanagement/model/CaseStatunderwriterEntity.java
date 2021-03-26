package com.hig.oracleformsmigration.casemanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CASE_STATUNDERWRITER")
public class CaseStatunderwriterEntity implements Serializable{
	
	
	@Column(name="CASEID")
	private String caseid;
	
	@Id
	@Column(name="STAT_UNDRWRTR")
	private String statUnderwriter;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="statUnderwriter",insertable = false, updatable = false)
	private ViewCmUnderwriterMaint1Entity viewCmUnderwriterMaint1Entity;
	

	public ViewCmUnderwriterMaint1Entity getViewCmUnderwriterMaint1Entity() {
		return viewCmUnderwriterMaint1Entity;
	}

	public void setViewCmUnderwriterMaint1Entity(ViewCmUnderwriterMaint1Entity viewCmUnderwriterMaint1Entity) {
		this.viewCmUnderwriterMaint1Entity = viewCmUnderwriterMaint1Entity;
	}

	public String getCaseid() {
		return caseid;
	}

	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}

	public String getStatUnderwriter() {
		return statUnderwriter;
	}

	public void setStatUnderwriter(String statUnderwriter) {
		this.statUnderwriter = statUnderwriter;
	}
}
