package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_HIG_ALL_REP1")
public class ViewHigAllRep {
	
	
	@Id
	@Column(name="REPID")
	private String Id;
	@Column(name="NAME")
	private String name;
	
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
	
	
}
