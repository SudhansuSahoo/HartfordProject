package com.hig.oracleformsmigration.lossprocessing.model;

public class SponsorPolicy {
	
	private String pSponsor;
	private String pMode;
	
	public SponsorPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SponsorPolicy(String pSponsor, String pMode) {
		super();
		this.pSponsor = pSponsor;
		this.pMode = pMode;
	}
	public String getpSponsor() {
		return pSponsor;
	}
	public void setpSponsor(String pSponsor) {
		this.pSponsor = pSponsor;
	}
	public String getpMode() {
		return pMode;
	}
	public void setpMode(String pMode) {
		this.pMode = pMode;
	}
	@Override
	public String toString() {
		return "SponsorPolicy [pSponsor=" + pSponsor + ", pMode=" + pMode + "]";
	}
	
	
}
