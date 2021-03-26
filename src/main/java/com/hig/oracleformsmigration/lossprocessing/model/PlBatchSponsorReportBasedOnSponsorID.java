package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PL_BATCH_SPONSOR_REPORT")
public class PlBatchSponsorReportBasedOnSponsorID {
	

	@Column(name="BUS_SPNSR_ID")
	private char bus_spnsr_Id;
    @Column(name="RPT_NM")
	private String rptNm;
    @Id
    @Column(name="ELECT_MAIL_DSTRIB_LIST")
    private String emaildistributionList;
    @Column(name="RPT_DESC")
    private String rptDesc;
    @Column(name="RPT_FREQ")
    private String rptFreq;
    
    
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
	public PlBatchSponsorReportBasedOnSponsorID(char bus_spnsr_Id, String rptNm, String emaildistributionList,
			String rptDesc, String rptFreq) {
		super();
		this.bus_spnsr_Id = bus_spnsr_Id;
		this.rptNm = rptNm;
		this.emaildistributionList = emaildistributionList;
		this.rptDesc = rptDesc;
		this.rptFreq = rptFreq;
	}
	public PlBatchSponsorReportBasedOnSponsorID() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
