package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATE_CODES")
public class StateCodesEntity {
	
	@Id
	@Column(name="STCD")
	private String stcd;
	@Column(name="NAME")
	private String name;
	@Column(name="WDIND")
	private String wdind;
	@Column(name="PRMMTXLCTNCDIND")
	private String prmmtxlctncdind;
	@Column(name="LGLSTCDIND")
	private String lglstcdind;
	public String getStcd() {
		return stcd;
	}
	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWdind() {
		return wdind;
	}
	public void setWdind(String wdind) {
		this.wdind = wdind;
	}
	public String getPrmmtxlctncdind() {
		return prmmtxlctncdind;
	}
	public void setPrmmtxlctncdind(String prmmtxlctncdind) {
		this.prmmtxlctncdind = prmmtxlctncdind;
	}
	public String getLglstcdind() {
		return lglstcdind;
	}
	public void setLglstcdind(String lglstcdind) {
		this.lglstcdind = lglstcdind;
	}
	public StateCodesEntity(String stcd, String name, String wdind, String prmmtxlctncdind, String lglstcdind) {
		super();
		this.stcd = stcd;
		this.name = name;
		this.wdind = wdind;
		this.prmmtxlctncdind = prmmtxlctncdind;
		this.lglstcdind = lglstcdind;
	}
	public StateCodesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
