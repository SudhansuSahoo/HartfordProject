package com.hig.oracleformsmigration.lossprocessing.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pl_benefit_log")
public class PlBenitfitLogTable {
	
	@Id
	@Column(name="LOGID")
	private String logId;
	@Column(name="PLCYNBR")
	private String plcyNbr;
	@Column(name="PLCYSYMBLTYP")
	private String plcysymblyp;
	@Column(name="CHCKNBR")
	private String chckNbr;
	@Column(name="BACISEFTID")
	private String baciseftid;
	@Column(name="BNFTCD1")
	private String bnftcd1;
	@Column(name="BNFTAMT1")
	private int bnftamt1;
	@Column(name="BNFTCD2")
	private String bnftcd2;
	@Column(name="BNFTAMT2")
	private int bnftamt2;
	@Column(name="BNFTCD3")
	private String bnftcd3;
	@Column(name="BNFTAMT3")
	private int bnftamt3;
	@Column(name="BNFTCD4")
	private String bnftcd4;
	@Column(name="BNFTAMT4")
	private int bnftamt4;
	@Column(name="BNFTCD5")
	private String bnftcd5;
	@Column(name="BNFTAMT5")
	private int bnftamt5;
	@Column(name="BNFTCD6")
	private String bnftcd6;
	@Column(name="BNFTAMT6")
	private int bnftamt6;
	@Column(name="BNFTCD7")
	private String bnftcd7;
	@Column(name="BNFTAMT7")
	private int bnftamt7;
	@Column(name="BNFTCD8")
	private String bnftcd8;
	@Column(name="BNFTAMT8")
	private int bnftamt8;
	@Column(name="PRCSRID")
	private String prcsrid;
	@Column(name="PRCSSDTTM")
	private String prcssdttm;
	@Column(name="SPNSRID")
	private String spnsrid;
	@Column(name="UPDTIND")
	private String updtInd;
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getPlcyNbr() {
		return plcyNbr;
	}
	public void setPlcyNbr(String plcyNbr) {
		this.plcyNbr = plcyNbr;
	}
	public String getPlcysymblyp() {
		return plcysymblyp;
	}
	public void setPlcysymblyp(String plcysymblyp) {
		this.plcysymblyp = plcysymblyp;
	}
	public String getChckNbr() {
		return chckNbr;
	}
	public void setChckNbr(String chckNbr) {
		this.chckNbr = chckNbr;
	}
	public String getBaciseftid() {
		return baciseftid;
	}
	public void setBaciseftid(String baciseftid) {
		this.baciseftid = baciseftid;
	}
	public String getBnftcd1() {
		return bnftcd1;
	}
	public void setBnftcd1(String bnftcd1) {
		this.bnftcd1 = bnftcd1;
	}
	public int getBnftamt1() {
		return bnftamt1;
	}
	public void setBnftamt1(int bnftamt1) {
		this.bnftamt1 = bnftamt1;
	}
	public String getBnftcd2() {
		return bnftcd2;
	}
	public void setBnftcd2(String bnftcd2) {
		this.bnftcd2 = bnftcd2;
	}
	public int getBnftamt2() {
		return bnftamt2;
	}
	public void setBnftamt2(int bnftamt2) {
		this.bnftamt2 = bnftamt2;
	}
	public String getBnftcd3() {
		return bnftcd3;
	}
	public void setBnftcd3(String bnftcd3) {
		this.bnftcd3 = bnftcd3;
	}
	public int getBnftamt3() {
		return bnftamt3;
	}
	public void setBnftamt3(int bnftamt3) {
		this.bnftamt3 = bnftamt3;
	}
	public String getBnftcd4() {
		return bnftcd4;
	}
	public void setBnftcd4(String bnftcd4) {
		this.bnftcd4 = bnftcd4;
	}
	public int getBnftamt4() {
		return bnftamt4;
	}
	public void setBnftamt4(int bnftamt4) {
		this.bnftamt4 = bnftamt4;
	}
	public String getBnftcd5() {
		return bnftcd5;
	}
	public void setBnftcd5(String bnftcd5) {
		this.bnftcd5 = bnftcd5;
	}
	public int getBnftamt5() {
		return bnftamt5;
	}
	public void setBnftamt5(int bnftamt5) {
		this.bnftamt5 = bnftamt5;
	}
	public String getBnftcd6() {
		return bnftcd6;
	}
	public void setBnftcd6(String bnftcd6) {
		this.bnftcd6 = bnftcd6;
	}
	public int getBnftamt6() {
		return bnftamt6;
	}
	public void setBnftamt6(int bnftamt6) {
		this.bnftamt6 = bnftamt6;
	}
	public String getBnftcd7() {
		return bnftcd7;
	}
	public void setBnftcd7(String bnftcd7) {
		this.bnftcd7 = bnftcd7;
	}
	public int getBnftamt7() {
		return bnftamt7;
	}
	public void setBnftamt7(int bnftamt7) {
		this.bnftamt7 = bnftamt7;
	}
	public String getBnftcd8() {
		return bnftcd8;
	}
	public void setBnftcd8(String bnftcd8) {
		this.bnftcd8 = bnftcd8;
	}
	public int getBnftamt8() {
		return bnftamt8;
	}
	public void setBnftamt8(int bnftamt8) {
		this.bnftamt8 = bnftamt8;
	}
	public String getPrcsrid() {
		return prcsrid;
	}
	public void setPrcsrid(String prcsrid) {
		this.prcsrid = prcsrid;
	}
	public String getPrcssdttm() {
		return prcssdttm;
	}
	public void setPrcssdttm(String prcssdttm) {
		this.prcssdttm = prcssdttm;
	}
	public String getSpnsrid() {
		return spnsrid;
	}
	public void setSpnsrid(String spnsrid) {
		this.spnsrid = spnsrid;
	}
	public String getUpdtInd() {
		return updtInd;
	}
	public void setUpdtInd(String updtInd) {
		this.updtInd = updtInd;
	}
	
	
	
}

