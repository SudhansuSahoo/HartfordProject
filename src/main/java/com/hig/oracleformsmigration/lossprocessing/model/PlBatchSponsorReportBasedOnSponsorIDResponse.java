package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class PlBatchSponsorReportBasedOnSponsorIDResponse {
	

	private String bus_spnsr_Id;
	private String rptNm;
    private String emaildistributionList;
    private String rptDesc;
    private String rptFreq;
    
	public String getBus_spnsr_Id() {
		return bus_spnsr_Id;
	}
	public void setBus_spnsr_Id(String bus_spnsr_Id) {
		this.bus_spnsr_Id = bus_spnsr_Id;
	}
	public String getRptNm() {
		return rptNm;
	}
	public void setRptNm(String rptNm) {
		this.rptNm = rptNm;
	}
	public String getEmaildistributionList() {
		return emaildistributionList;
	}
	public void setEmaildistributionList(String emaildistributionList) {
		this.emaildistributionList = emaildistributionList;
	}
	public String getRptDesc() {
		return rptDesc;
	}
	public void setRptDesc(String rptDesc) {
		this.rptDesc = rptDesc;
	}
	public String getRptFreq() {
		return rptFreq;
	}
	public void setRptFreq(String rptFreq) {
		this.rptFreq = rptFreq;
	}
	public PlBatchSponsorReportBasedOnSponsorIDResponse(String bus_spnsr_Id, String rptNm, String emaildistributionList,
			String rptDesc, String rptFreq) {
		super();
		this.bus_spnsr_Id = bus_spnsr_Id;
		this.rptNm = rptNm;
		this.emaildistributionList = emaildistributionList;
		this.rptDesc = rptDesc;
		this.rptFreq = rptFreq;
	}
	public PlBatchSponsorReportBasedOnSponsorIDResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
