package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_CASE_PRODUCER_UNDRWRTR1")
public class ViewCaseProducerUndrwrtr {
	
	@Id
	@Column(name="VNDRID")
	private String vndrId;
	
	@Column(name="PRODUCER")
	private String producer;
	
	@Column(name="UNDRWRTR")
	private String undrwrtr;

	public String getVndrId() {
		return vndrId;
	}

	public void setVndrId(String vndrId) {
		this.vndrId = vndrId;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getUndrwrtr() {
		return undrwrtr;
	}

	public void setUndrwrtr(String undrwrtr) {
		this.undrwrtr = undrwrtr;
	}

	public ViewCaseProducerUndrwrtr(String vndrId, String producer, String undrwrtr) {
		super();
		this.vndrId = vndrId;
		this.producer = producer;
		this.undrwrtr = undrwrtr;
	}

	public ViewCaseProducerUndrwrtr() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
