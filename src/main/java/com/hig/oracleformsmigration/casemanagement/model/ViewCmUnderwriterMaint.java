package com.hig.oracleformsmigration.casemanagement.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="VIEW_CM_UNDERWRITER_MAINT1")
public class ViewCmUnderwriterMaint {
	
	
	@Id
	@Column(name="UNDRWRTR")
	private String underwriter;
	@Column(name="NAME")
	private String name;
	
	
	public String getUnderwriter() {
		return underwriter;
	}
	public void setUnderwriter(String underwriter) {
		this.underwriter = underwriter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
