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
public class PlBatchSponsorReport {
	
	
	@Column(name="BUS_SPNSR_ID")
	private String busspnsrId;
    @Column(name="RPT_NM")
	private String rptNm;
    @Id
    @Column(name="ELECT_MAIL_DSTRIB_LIST")
    private String emaildistributionList;
    @Column(name="RPT_DESC")
    private String rptDesc;
    @Column(name="RPT_FREQ")
    private String rptFreq;
    
    
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="emaildistributionList",insertable = false, updatable = false)
	private PlBatchReportDistributionList plBatchReportDistributionList;
    
	public PlBatchReportDistributionList getPlBatchReportDistributionList() {
		return plBatchReportDistributionList;
	}
	public void setPlBatchReportDistributionList(PlBatchReportDistributionList plBatchReportDistributionList) {
		this.plBatchReportDistributionList = plBatchReportDistributionList;
	}
	public String getBusspnsrId() {
		return busspnsrId;
	}
	public void setBusspnsrId(String busspnsrId) {
		this.busspnsrId = busspnsrId;
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
}
