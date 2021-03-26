package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="view_policy_number_undrwrtr1")
public class ViewPolicyNumberUndrwrtr {
	@Id
	@Column(name="PLCYNBR")
	private String plcynbr;

	public String getPlcynbr() {
		return plcynbr;
	}

	public void setPlcynbr(String plcynbr) {
		this.plcynbr = plcynbr;
	}

	public ViewPolicyNumberUndrwrtr(String plcynbr) {
		super();
		this.plcynbr = plcynbr;
	}

	public ViewPolicyNumberUndrwrtr() {
		super();
		// TODO Auto-generated constructor stub
	}
}
