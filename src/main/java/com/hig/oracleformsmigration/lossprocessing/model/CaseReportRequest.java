package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="case_report_request")
public class CaseReportRequest implements Serializable{
	@Id
	@Column(name="RPRTRQSTID")
	private String rprtrqstId;
	@Column(name="CASEID")
	private String caseId;
	@Column(name="RPRTGRPID")
	private String rprtgrpId;
	@Column(name="RPRTTYPID")
	private String rprttypId;
	@Column(name="RPRTRQSTSTRTDT")
	private String rprtrqstsstrtdt;
	@Column(name="RPRTRQSTENDDT")
	private String rprtrqstenddt;
	@Column(name="DSCRPTN")
	private String dscrptn;
	
	
	public String getRprtrqstId() {
		return rprtrqstId;
	}
	public void setRprtrqstId(String rprtrqstId) {
		this.rprtrqstId = rprtrqstId;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getRprtgrpId() {
		return rprtgrpId;
	}
	public void setRprtgrpId(String rprtgrpId) {
		this.rprtgrpId = rprtgrpId;
	}
	public String getRprttypId() {
		return rprttypId;
	}
	public void setRprttypId(String rprttypId) {
		this.rprttypId = rprttypId;
	}
	public String getRprtrqstsstrtdt() {
		return rprtrqstsstrtdt;
	}
	public void setRprtrqstsstrtdt(String rprtrqstsstrtdt) {
		this.rprtrqstsstrtdt = rprtrqstsstrtdt;
	}
	public String getRprtrqstenddt() {
		return rprtrqstenddt;
	}
	public void setRprtrqstenddt(String rprtrqstenddt) {
		this.rprtrqstenddt = rprtrqstenddt;
	}
	public String getDscrptn() {
		return dscrptn;
	}
	public void setDscrptn(String dscrptn) {
		this.dscrptn = dscrptn;
	}
	
	
	
	
	
}
