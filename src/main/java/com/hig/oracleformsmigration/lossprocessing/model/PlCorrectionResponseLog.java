package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class PlCorrectionResponseLog {
	
	private int pcheckamt;
	private String psponsorid;
	private String psponsorname;
	private String ppolicyholdername;
	private String pinsuredname;
	private String pinsuredssn;
	private String errorCode;
	private String errorMessage;
	private PolicyDetails PolicyDetails;
	
	
	
	public PolicyDetails getPolicyDetails() {
		return PolicyDetails;
	}
	public void setPolicyDetails(PolicyDetails policyDetails) {
		PolicyDetails = policyDetails;
	}
	public int getPcheckamt() {
		return pcheckamt;
	}
	public void setPcheckamt(int pcheckamt) {
		this.pcheckamt = pcheckamt;
	}
	public String getPsponsorid() {
		return psponsorid;
	}
	public void setPsponsorid(String psponsorid) {
		this.psponsorid = psponsorid;
	}
	public String getPsponsorname() {
		return psponsorname;
	}
	public void setPsponsorname(String psponsorname) {
		this.psponsorname = psponsorname;
	}
	public String getPpolicyholdername() {
		return ppolicyholdername;
	}
	public void setPpolicyholdername(String ppolicyholdername) {
		this.ppolicyholdername = ppolicyholdername;
	}
	public String getPinsuredname() {
		return pinsuredname;
	}
	public void setPinsuredname(String pinsuredname) {
		this.pinsuredname = pinsuredname;
	}
	public String getPinsuredssn() {
		return pinsuredssn;
	}
	public void setPinsuredssn(String pinsuredssn) {
		this.pinsuredssn = pinsuredssn;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errosMessage) {
		this.errorMessage = errosMessage;
	}
	public PlCorrectionResponseLog(int pcheckamt, String psponsorid, String psponsorname, String ppolicyholdername,
			String pinsuredname, String pinsuredssn, String errorCode, String errorMessage) {
		super();
		this.pcheckamt = pcheckamt;
		this.psponsorid = psponsorid;
		this.psponsorname = psponsorname;
		this.ppolicyholdername = ppolicyholdername;
		this.pinsuredname = pinsuredname;
		this.pinsuredssn = pinsuredssn;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public PlCorrectionResponseLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
