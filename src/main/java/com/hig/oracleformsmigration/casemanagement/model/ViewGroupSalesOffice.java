package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="VIEW_GROUP_SALES_OFFICE1")
public class ViewGroupSalesOffice {
	@Column(name="SLSOFFCCD")
	@Id
	private int Id;
	@Column(name="NAME")
	private String name;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ViewGroupSalesOffice [Id=" + Id + ", name=" + name + "]";
	}
	public ViewGroupSalesOffice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewGroupSalesOffice(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}
	
}
