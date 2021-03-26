package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="VIEW_GLO_MOD1")
public class ViewGloMod {
	
	@Id
	@Column(name="OPTNID")
	private String optnId;
	@Column(name="CASEID")
	private String caseId;
	@Column(name="VNDRID")
	private String vndrId;
	@Column(name="SLSOFFCCD")
	private int slsoffccd;
	@Column(name="SALESREP")
	private String salesrep;
	@Column(name="SLSREPID")
	private String slsrepId;
	@Column(name="SVCREPID")
	private String svcrepId;
	public String getUndrwrtr() {
		return undrwrtr;
	}
	public void setUndrwrtr(String undrwrtr) {
		this.undrwrtr = undrwrtr;
	}
	@Column(name="CASENAME")
	private String casename;
	@Column(name="SERVICETEAM")
	private String serviceteam;
	@Column(name="PRODUCER")
	private String producer;
	@Column(name="SALESOFFICE")
	private String salesoffice;
	@Column(name="SERVICEREP")
	private String servicerep;
	
	@Column(name="UNDRWRTR")
	private String undrwrtr;
	
	public String getOptnId() {
		return optnId;
	}
	public void setOptnId(String optnId) {
		this.optnId = optnId;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getVndrId() {
		return vndrId;
	}
	public void setVndrId(String vndrId) {
		this.vndrId = vndrId;
	}
	
	public int getSlsoffccd() {
		return slsoffccd;
	}
	public void setSlsoffccd(int slsoffccd) {
		this.slsoffccd = slsoffccd;
	}
	public String getSalesrep() {
		return salesrep;
	}
	public void setSalesrep(String salesrep) {
		this.salesrep = salesrep;
	}
	
	public String getSlsrepId() {
		return slsrepId;
	}
	public void setSlsrepId(String slsrepId) {
		this.slsrepId = slsrepId;
	}
	public String getSvcrepId() {
		return svcrepId;
	}
	public void setSvcrepId(String svcrepId) {
		this.svcrepId = svcrepId;
	}
	public String getCasename() {
		return casename;
	}
	public void setCasename(String casename) {
		this.casename = casename;
	}
	public String getServiceteam() {
		return serviceteam;
	}
	public void setServiceteam(String serviceteam) {
		this.serviceteam = serviceteam;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getSalesoffice() {
		return salesoffice;
	}
	public void setSalesoffice(String salesoffice) {
		this.salesoffice = salesoffice;
	}
	public String getServicerep() {
		return servicerep;
	}
	public void setServicerep(String servicerep) {
		this.servicerep = servicerep;
	}
	
	public ViewGloMod(String optnId, String caseId, String vndrId, int slsoffccd, String salesrep, String slsrepId,
			String svcrepId, String casename, String serviceteam, String salesoffice, String producer, String servicerep) {
		super();
		this.optnId = optnId;
		this.caseId = caseId;
		this.vndrId = vndrId;
		this.slsoffccd = slsoffccd;
		this.salesrep = salesrep;
		this.slsrepId = slsrepId;
		this.svcrepId = svcrepId;
		this.casename = casename;
		this.serviceteam = serviceteam;
		this.producer = producer;
		this.salesoffice = salesoffice;
		this.servicerep = servicerep;
	}
	public ViewGloMod() {
		super();
		// TODO Auto-generated constructor stub
	}

}
