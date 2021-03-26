package com.hig.oracleformsmigration.lossprocessing.model;

import java.io.Serializable;

public class SponsorResponse implements Serializable{
	
	private String description;
	private String spnsrid;
	

	public String getSpnsrid() {
		return spnsrid;
	}

	public void setSpnsrid(String spnsrid) {
		this.spnsrid = spnsrid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SponsorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SponsorResponse(String description, String spnsrid) {
		super();
		this.description = description;
		this.spnsrid = spnsrid;
	}

	public SponsorResponse(String description) {
		super();
		this.description = description;
	}
	
	

}
