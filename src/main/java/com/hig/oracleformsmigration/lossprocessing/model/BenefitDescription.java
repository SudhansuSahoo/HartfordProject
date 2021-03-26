package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PL_BENEFIT_CODE")
public class BenefitDescription {

	@Id
	@Column(name="BNFTCD", unique=true, nullable = false)
	private String bnftcd;//BNFTCD
	@Column(name="DSCRPTN")
	private String desc;//DSCRPTN
	@Column(name="TXBLBNFTIND")
	private String txblbnftInd;//TXBLBNFTIND
	@Column(name="CVRGCTGRYCD")
	private String cvrgctgrycd;//CVRGCTGRYCD
	@Column(name="LSSEXPRNCCD")
	private String lssexprccd;//LSSEXPRNCCD
	@Column(name="SBCLMTYPCD")
	private String sbclmtypcd;//SBCLMTYPCD
	@Column(name="MJRLNCD")
	private String mjrlncd;//MJRLNCD
	@Column(name="LSSRPRTNGGRPNGCD")
	private String lssrprtnggrpngcd;//LSSRPRTNGGRPNGCD
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTxblbnftInd() {
		return txblbnftInd;
	}
	public void setTxblbnftInd(String txblbnftInd) {
		this.txblbnftInd = txblbnftInd;
	}
	public String getCvrgctgrycd() {
		return cvrgctgrycd;
	}
	public void setCvrgctgrycd(String cvrgctgrycd) {
		this.cvrgctgrycd = cvrgctgrycd;
	}
	public String getLssexprccd() {
		return lssexprccd;
	}
	public void setLssexprccd(String lssexprccd) {
		this.lssexprccd = lssexprccd;
	}
	public String getSbclmtypcd() {
		return sbclmtypcd;
	}
	public void setSbclmtypcd(String sbclmtypcd) {
		this.sbclmtypcd = sbclmtypcd;
	}
	public String getMjrlncd() {
		return mjrlncd;
	}
	public void setMjrlncd(String mjrlncd) {
		this.mjrlncd = mjrlncd;
	}
	public String getLssrprtnggrpngcd() {
		return lssrprtnggrpngcd;
	}
	public void setLssrprtnggrpngcd(String lssrprtnggrpngcd) {
		this.lssrprtnggrpngcd = lssrprtnggrpngcd;
	}
	
	
	public String getBnftcd() {
		return bnftcd;
	}
	public void setBnftcd(String bnftcd) {
		this.bnftcd = bnftcd;
	}
	public BenefitDescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BenefitDescription(String bnftcd, String desc, String txblbnftInd, String cvrgctgrycd, String lssexprccd,
			String sbclmtypcd, String mjrlncd, String lssrprtnggrpngcd) {
		super();
		this.bnftcd = bnftcd;
		this.desc = desc;
		this.txblbnftInd = txblbnftInd;
		this.cvrgctgrycd = cvrgctgrycd;
		this.lssexprccd = lssexprccd;
		this.sbclmtypcd = sbclmtypcd;
		this.mjrlncd = mjrlncd;
		this.lssrprtnggrpngcd = lssrprtnggrpngcd;
	}
	
	
}
