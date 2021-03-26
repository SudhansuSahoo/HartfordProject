package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_STAT_UNDERWRITER1")
public class ViewStatUnderwriter {
	
	
	@Id
	@Column(name="UNDRWRTR")
	private String Id;
	@Column(name="NAME")
	private String name;
	@Column(name="DSCRPTN")
	private String description;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
