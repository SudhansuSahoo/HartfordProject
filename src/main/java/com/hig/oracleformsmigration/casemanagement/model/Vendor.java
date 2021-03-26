package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table
public class Vendor {

	@Id
	@Column(name="VNDRID")
	private String vndrId;
	
	@Column(name="NAME")
	private String name;

	public String getVndrId() {
		return vndrId;
	}

	public void setVndrId(String vndrId) {
		this.vndrId = vndrId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vendor(String vndrId, String name) {
		super();
		this.vndrId = vndrId;
		this.name = name;
	}

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
}
