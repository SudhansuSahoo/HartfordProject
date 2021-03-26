package com.hig.oracleformsmigration.casemanagement.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_CM_UNDERWRITER_MAINT1")
public class ViewCmUnderwriterMaint1Entity implements Serializable{
	
	@Id
	@Column(name="UNDRWRTR")
	private String undrwrtr;
	
	@Column(name="NAME")
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="undrwrtr")
	private CaseStatunderwriterEntity  caseStatunderwriterEntity;
	
	
	public CaseStatunderwriterEntity getCaseStatunderwriterEntity() {
		return caseStatunderwriterEntity;
	}
	public void setCaseStatunderwriterEntity(CaseStatunderwriterEntity caseStatunderwriterEntity) {
		this.caseStatunderwriterEntity = caseStatunderwriterEntity;
	}
	
	public String getUndrwrtr() {
		return undrwrtr;
	}
	public void setUndrwrtr(String undrwrtr) {
		this.undrwrtr = undrwrtr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
