package com.hig.oracleformsmigration.casemanagement.model;

public class ProducerResponse {
	
	private String message;
	private int statusCode;
	private String caseId;
	private String caseName;
	private String producer;
	private String salesOffice;
	private String underWriter;
	private String undrWrtr;
	private String salesRep;
	private String statUnderwriter;
	private String psTeam;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getSalesOffice() {
		return salesOffice;
	}
	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}
	public String getUnderWriter() {
		return underWriter;
	}
	public void setUnderWriter(String underWriter) {
		this.underWriter = underWriter;
	}
	public String getUndrWrtr() {
		return undrWrtr;
	}
	public void setUndrWrtr(String undrWrtr) {
		this.undrWrtr = undrWrtr;
	}
	public String getSalesRep() {
		return salesRep;
	}
	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}
	public String getStatUnderwriter() {
		return statUnderwriter;
	}
	public void setStatUnderwriter(String statUnderwriter) {
		this.statUnderwriter = statUnderwriter;
	}
	public String getPsTeam() {
		return psTeam;
	}
	public void setPsTeam(String psTeam) {
		this.psTeam = psTeam;
	}
	public ProducerResponse(String message, int statusCode, String caseId, String caseName, String producer,
			String salesOffice, String underWriter, String undrWrtr, String salesRep, String statUnderwriter,
			String psTeam) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.caseId = caseId;
		this.caseName = caseName;
		this.producer = producer;
		this.salesOffice = salesOffice;
		this.underWriter = underWriter;
		this.undrWrtr = undrWrtr;
		this.salesRep = salesRep;
		this.statUnderwriter = statUnderwriter;
		this.psTeam = psTeam;
	}
	public ProducerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProducerResponse [message=" + message + ", statusCode=" + statusCode + ", caseId=" + caseId
				+ ", caseName=" + caseName + ", producer=" + producer + ", salesOffice=" + salesOffice
				+ ", underWriter=" + underWriter + ", undrWrtr=" + undrWrtr + ", salesRep=" + salesRep
				+ ", statUnderwriter=" + statUnderwriter + ", psTeam=" + psTeam + "]";
	}
	
	

}
