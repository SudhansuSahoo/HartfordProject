package com.hig.oracleformsmigration.lossprocessing.model;

public class BatchSponsorDistributionReportRelationship {
	
	private String usrNm;
	private String rptNm;
	private String rptDesc;
	private String emldstntn;
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	public String getRptNm() {
		return rptNm;
	}
	public void setRptNm(String rptNm) {
		this.rptNm = rptNm;
	}
	public String getRptDesc() {
		return rptDesc;
	}
	public void setRptDesc(String rptDesc) {
		this.rptDesc = rptDesc;
	}
	public String getEmldstntn() {
		return emldstntn;
	}
	public void setEmldstntn(String emldstntn) {
		this.emldstntn = emldstntn;
	}
	public BatchSponsorDistributionReportRelationship(String usrNm, String rptNm, String rptDesc, String emldstntn) {
		super();
		this.usrNm = usrNm;
		this.rptNm = rptNm;
		this.rptDesc = rptDesc;
		this.emldstntn = emldstntn;
	}
	public BatchSponsorDistributionReportRelationship() {
		super();
		// TODO Auto-generated constructor stub
	}
}
