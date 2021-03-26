package com.hig.oracleformsmigration.model.response;

public class ViewGroupSalesOfficeObj {
	
	private int Id;
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
	public ViewGroupSalesOfficeObj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewGroupSalesOfficeObj(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}
	
}
