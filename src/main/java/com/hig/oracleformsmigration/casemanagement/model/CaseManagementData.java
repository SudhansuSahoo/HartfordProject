package com.hig.oracleformsmigration.casemanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import com.hig.oracleformsmigration.casemanagement.model.CaseDocument;


@Entity
@Table(name="CASEMANAGEMENTDATA")
public class CaseManagementData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cmdid")
	private int id;
	@Column(name="FORMTYPE")
	private String formType;
	@Column(name="PRODUCERID")
	private String producerID;
	@Column(name="UNDERWRITERID")
	private String underWriterID;
	@Column(name="SALESOFFICEID")
	private String salesOfficeID;
	@Column(name="SALESREPID")
	private String salesRepID;
	@Column(name="SERVICEREPID")
	private String serviceRepID;
	@Column(name="STATUWID")
	private String statUWID;
	@Column(name="PRIMARYSERVICETEAMID")
	private String primaryServiceTeamID;
	@Column(name="ADDITIONALSERVICETEAMID")
	private String additionalServiceTeamID;
	@Column(name="CASELABELID")
	private String caseLabelID;
	@Column(name="SITUSSTATEID")
	private String situsStateID;
	@Column(name="POLICYNUMBERID")
	private String policyNumberID;
	@Column(name="CASESTATUSID")
	private String caseStatusID;
	@Column(name="NEWUNDERWRITERID")
	private String newUnderWriterID;
	
	@OneToMany(targetEntity = CaseDocument.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cmdid", referencedColumnName = "cmdid")
	private List<CaseDocument> cases;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getProducerID() {
		return producerID;
	}

	public void setProducerID(String producerID) {
		this.producerID = producerID;
	}

	public String getUnderWriterID() {
		return underWriterID;
	}

	public void setUnderWriterID(String underWriterID) {
		this.underWriterID = underWriterID;
	}

	public String getSalesOfficeID() {
		return salesOfficeID;
	}

	public void setSalesOfficeID(String salesOfficeID) {
		this.salesOfficeID = salesOfficeID;
	}

	public String getSalesRepID() {
		return salesRepID;
	}

	public void setSalesRepID(String salesRepID) {
		this.salesRepID = salesRepID;
	}

	public String getServiceRepID() {
		return serviceRepID;
	}

	public void setServiceRepID(String serviceRepID) {
		this.serviceRepID = serviceRepID;
	}

	public String getStatUWID() {
		return statUWID;
	}

	public void setStatUWID(String statUWID) {
		this.statUWID = statUWID;
	}

	public String getPrimaryServiceTeamID() {
		return primaryServiceTeamID;
	}

	public void setPrimaryServiceTeamID(String primaryServiceTeamID) {
		this.primaryServiceTeamID = primaryServiceTeamID;
	}

	public String getAdditionalServiceTeamID() {
		return additionalServiceTeamID;
	}

	public void setAdditionalServiceTeamID(String additionalServiceTeamID) {
		this.additionalServiceTeamID = additionalServiceTeamID;
	}

	public String getCaseLabelID() {
		return caseLabelID;
	}

	public void setCaseLabelID(String caseLabelID) {
		this.caseLabelID = caseLabelID;
	}

	public String getSitusStateID() {
		return situsStateID;
	}

	public void setSitusStateID(String situsStateID) {
		this.situsStateID = situsStateID;
	}

	public String getPolicyNumberID() {
		return policyNumberID;
	}

	public void setPolicyNumberID(String policyNumberID) {
		this.policyNumberID = policyNumberID;
	}

	public String getCaseStatusID() {
		return caseStatusID;
	}

	public void setCaseStatusID(String caseStatusID) {
		this.caseStatusID = caseStatusID;
	}

	public String getNewUnderWriterID() {
		return newUnderWriterID;
	}

	public void setNewUnderWriterID(String newUnderWriterID) {
		this.newUnderWriterID = newUnderWriterID;
	}

	public List<CaseDocument> getCases() {
		return cases;
	}

	public void setCases(List<CaseDocument> cases) {
		this.cases = cases;
	}

	public CaseManagementData(int id, String formType, String producerID, String underWriterID, String salesOfficeID,
			String salesRepID, String serviceRepID, String statUWID, String primaryServiceTeamID,
			String additionalServiceTeamID, String caseLabelID, String situsStateID, String policyNumberID,
			String caseStatusID, String newUnderWriterID, List<CaseDocument> cases) {
		super();
		this.id = id;
		this.formType = formType;
		this.producerID = producerID;
		this.underWriterID = underWriterID;
		this.salesOfficeID = salesOfficeID;
		this.salesRepID = salesRepID;
		this.serviceRepID = serviceRepID;
		this.statUWID = statUWID;
		this.primaryServiceTeamID = primaryServiceTeamID;
		this.additionalServiceTeamID = additionalServiceTeamID;
		this.caseLabelID = caseLabelID;
		this.situsStateID = situsStateID;
		this.policyNumberID = policyNumberID;
		this.caseStatusID = caseStatusID;
		this.newUnderWriterID = newUnderWriterID;
		this.cases = cases;
	}

	public CaseManagementData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CaseManagementData [id=" + id + ", formType=" + formType + ", producerID=" + producerID
				+ ", underWriterID=" + underWriterID + ", salesOfficeID=" + salesOfficeID + ", salesRepID=" + salesRepID
				+ ", serviceRepID=" + serviceRepID + ", statUWID=" + statUWID + ", primaryServiceTeamID="
				+ primaryServiceTeamID + ", additionalServiceTeamID=" + additionalServiceTeamID + ", caseLabelID="
				+ caseLabelID + ", situsStateID=" + situsStateID + ", policyNumberID=" + policyNumberID
				+ ", caseStatusID=" + caseStatusID + ", newUnderWriterID=" + newUnderWriterID + ", cases=" + cases
				+ "]";
	}
	
}
