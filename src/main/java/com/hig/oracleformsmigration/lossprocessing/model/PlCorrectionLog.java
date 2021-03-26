package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class PlCorrectionLog {
	
	private String plogid;
	private String ppolicyno;
	private String ppolicynotype;
	private String pcheckno;
	private String peftno;
	private String psptxnno;
	public String getPlogid() {
		return plogid;
	}
	public void setPlogid(String plogid) {
		this.plogid = plogid;
	}
	public String getPpolicyno() {
		return ppolicyno;
	}
	public void setPpolicyno(String ppolicyno) {
		this.ppolicyno = ppolicyno;
	}
	public String getPpolicynotype() {
		return ppolicynotype;
	}
	public void setPpolicynotype(String ppolicynotype) {
		this.ppolicynotype = ppolicynotype;
	}
	public String getPcheckno() {
		return pcheckno;
	}
	public void setPcheckno(String pcheckno) {
		this.pcheckno = pcheckno;
	}
	public String getPeftno() {
		return peftno;
	}
	public void setPeftno(String peftno) {
		this.peftno = peftno;
	}
	public String getPsptxnno() {
		return psptxnno;
	}
	public void setPsptxnno(String psptxnno) {
		this.psptxnno = psptxnno;
	}
	public PlCorrectionLog(String plogid, String ppolicyno, String ppolicynotype, String pcheckno, String peftno,
			String psptxnno) {
		super();
		this.plogid = plogid;
		this.ppolicyno = ppolicyno;
		this.ppolicynotype = ppolicynotype;
		this.pcheckno = pcheckno;
		this.peftno = peftno;
		this.psptxnno = psptxnno;
	}
	public PlCorrectionLog() {
		super();
		// TODO Auto-generated constructor stub
	}

}
