package com.hig.oracleformsmigration.casemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COVERAGE_PROVISION_OPTION")
public class CoverageProvisionOptionEntity {
	
	@Id
	@Column(name= "DSCRPTN")
	private String description;

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CoverageProvisionOptionEntity(String description) {
		super();
		
		this.description = description;
	}

	public CoverageProvisionOptionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	/*Name                     Null?    Type               
			------------------------ -------- ------------------ 
			PRVSNID                  NOT NULL VARCHAR2(4)        
			CVRGCTGRYCD              NOT NULL VARCHAR2(4)        
			CVRGTYPCD                NOT NULL VARCHAR2(4)        
			OPTNID                   NOT NULL VARCHAR2(4)        
			FNDNGMTHDCD              NOT NULL VARCHAR2(4)        
			DSCRPTN                           VARCHAR2(250 CHAR) 
			SPCLIND                           VARCHAR2(1)        
			OPTNSRTORDR              NOT NULL NUMBER(4)          
			MDFYIND                           VARCHAR2(1)        
			CHNGDT                            DATE               
			NMRCDSCRPTN                       NUMBER(12,7)       
			OPTNTRMDT                         DATE               
			NODETYPCD                         VARCHAR2(4)        
			PROD_PRVSN_OPT_ID                 NUMBER             
			PRVSNSRTORDR                      NUMBER             
			DFLT_VAL_TXT                      VARCHAR2(100 CHAR) 
			OPTNTYPCD                         VARCHAR2(4 CHAR)   
			PARNT_RELAT_PRVSN_OPT_ID          NUMBER             
			OPT_VAL_NUM                       NUMBER             
			DRTNIND                           VARCHAR2(1 CHAR)   
			NON_STAN_OFFER_IND                VARCHAR2(1 CHAR)   
			HSA_CMPTBL_OPT_ID                 NUMBER             
			HIER_LVL_ID                       NUMBER             
			CLM_DSPLY_IND                     VARCHAR2(1 CHAR)   
			ST_CD                             VARCHAR2(2 CHAR)   
*/
}
