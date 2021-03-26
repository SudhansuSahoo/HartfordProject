package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Column;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="sponsor")
public class Sponsor implements Serializable{
	@Id
	@Column(name="SPNSRID")
	private String spnsrId;
	
	@Column(name="DSCRPTN")
	private String dscrptn;

	public String getSpnsrId() {
		return spnsrId;
	}

	public void setSpnsrId(String spnsrId) {
		this.spnsrId = spnsrId;
	}

	public String getDscrptn() {
		return dscrptn;
	}

	public void setDscrptn(String dscrptn) {
		this.dscrptn = dscrptn;
	}

	public Sponsor(String spnsrId, String dscrptn) {
		super();
		this.spnsrId = spnsrId;
		this.dscrptn = dscrptn;
	}

	public Sponsor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
