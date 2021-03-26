package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="PL_BATCH_REPORT_DIST_LIST")
public class PlBatchReportDistributionEmailReport {
	
	
	@Column(name="EMLDSTNTN")
	private String emldstntn;
	@Id
	@Column(name="USRNM")
	private String usrnm;
	@Column(name="EMLTYPCD")
	private String emltypcd;
	@Column(name="PRCSSDT")
	private String prcssdt;
	@Column(name="PRCSRID")
	private String prcsrid;
	
	
	public String getEmltypcd() {
		return emltypcd;
	}
	public void setEmltypcd(String emltypcd) {
		this.emltypcd = emltypcd;
	}
	
	public String getEmldstntn() {
		return emldstntn;
	}
	public void setEmldstntn(String emldstntn) {
		this.emldstntn = emldstntn;
	}
	public String getUsrnm() {
		return usrnm;
	}
	public void setUsrnm(String usrnm) {
		this.usrnm = usrnm;
	}
	public String getPrcssdt() {
		return prcssdt;
	}
	public void setPrcssdt(String prcssdt) {
		this.prcssdt = prcssdt;
	}
	public String getPrcsrid() {
		return prcsrid;
	}
	public void setPrcsrid(String prcsrid) {
		this.prcsrid = prcsrid;
	}
	public PlBatchReportDistributionEmailReport(String emldstntn, String usrnm, String emltypcd, String prcssdt,
			String prcsrid) {
		super();
		this.emldstntn = emldstntn;
		this.usrnm = usrnm;
		this.emltypcd = emltypcd;
		this.prcssdt = prcssdt;
		this.prcsrid = prcsrid;
	}
	public PlBatchReportDistributionEmailReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
