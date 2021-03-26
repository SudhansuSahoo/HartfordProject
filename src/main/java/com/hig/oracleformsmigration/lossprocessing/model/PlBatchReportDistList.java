package com.hig.oracleformsmigration.lossprocessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="PL_BATCH_REPORT_DIST_LIST")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "LP_INS_DEL_MAILDIST_1", 
	                              procedureName = "LP_INS_DEL_MAILDIST_1",
	                              parameters = {
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pmailid", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pmaildistribution", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "puserid", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "paction", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.OUT, name = "errorcode", type = Integer.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.OUT, name = "errormessage", type = String.class)
	                              })
})
public class PlBatchReportDistList {

	@Id
	@Column(name="EMLDSTNTN")
	private String pmailid;
	@Column(name="USRNM")
	private String pmaildistribution;
	@Column(name="EMLTYPCD")//'I' or 'D'
	private String paction;
	@Column(name="PRCSSDT")//sysdate
	private String prcssdt;
	@Column(name="PRCSRID")
	private String puserid;
	public String getPmailid() {
		return pmailid;
	}
	public void setPmailid(String pmailid) {
		this.pmailid = pmailid;
	}
	public String getPmaildistribution() {
		return pmaildistribution;
	}
	public void setPmaildistribution(String pmaildistribution) {
		this.pmaildistribution = pmaildistribution;
	}
	public String getPaction() {
		return paction;
	}
	public void setPaction(String paction) {
		this.paction = paction;
	}
	public String getPrcssdt() {
		return prcssdt;
	}
	public void setPrcssdt(String prcssdt) {
		this.prcssdt = prcssdt;
	}
	public String getPuserid() {
		return puserid;
	}
	public void setPuserid(String puserid) {
		this.puserid = puserid;
	}
	public PlBatchReportDistList(String pmailid, String pmaildistribution, String paction, String prcssdt, String puserid) {
		super();
		this.pmailid = pmailid;
		this.pmaildistribution = pmaildistribution;
		this.paction = paction;
		this.prcssdt = prcssdt;
		this.puserid = puserid;
	}
	public PlBatchReportDistList() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InsDelMailDist [pmailid=" + pmailid + ", pmaildistribution=" + pmaildistribution + ", paction="
				+ paction + ", prcssdt=" + prcssdt + ", puserid=" + puserid + "]";
	}
		
}
