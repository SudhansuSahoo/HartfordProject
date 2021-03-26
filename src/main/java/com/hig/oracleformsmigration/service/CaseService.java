package com.hig.oracleformsmigration.service;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hig.oracleformsmigration.casemanagement.model.CaseManagement;
import com.hig.oracleformsmigration.casemanagement.model.CaseManagementResponse;
import com.hig.oracleformsmigration.casemanagement.model.CaseID;
import com.hig.oracleformsmigration.util.GetEntityManager;


@Service
public class CaseService  {

	@Autowired
	private GetEntityManager getEntityManager;
	
	
	public CaseManagementResponse updateCaseManagement(CaseManagement caseManagement) {
		
		boolean errorFlg = false;
		int errorCode = 0;
		String l_caseID = "";
//		System.out.println("CaseService.updateCaseManagement() formtype = " + caseManagement.getFormType());
		
		if ("salesRep".equals(caseManagement.getFormType())) {

			for(CaseID cases :caseManagement.getCases()) {
//				cmSubmitSalesRepsp (caseManagement, cases.getCaseId());
				StoredProcedureQuery storedProcedure = getEntityManager.fetchEntityManager().createStoredProcedureQuery("CM_submit_sales_rep");

				storedProcedure.registerStoredProcedureParameter("pcaseid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("pcurrentsalesrepid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("pnewsalesrepid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("pnewservicerepid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("pnewsalesofficeid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("puserid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("errorcode", Integer.class, ParameterMode.OUT);
		        storedProcedure.registerStoredProcedureParameter("errormessage", String.class, ParameterMode.OUT);
		        storedProcedure.setParameter("pcaseid", cases.getCaseId());
		        storedProcedure.setParameter("pcurrentsalesrepid", caseManagement.getSalesRepID()!=null? caseManagement.getSalesRepID(): "");
		        storedProcedure.setParameter("pnewsalesrepid", caseManagement.getNewSalesRepID()!=null? caseManagement.getNewSalesRepID() : "");
		        storedProcedure.setParameter("pnewservicerepid", caseManagement.getNewServiceRepID()!=null? caseManagement.getNewServiceRepID() : "");
		        storedProcedure.setParameter("pnewsalesofficeid", caseManagement.getNewSalesOfficeID()!=null? caseManagement.getNewSalesOfficeID(): "");
		        storedProcedure.setParameter("puserid", caseManagement.getUserId()!=null ? caseManagement.getUserId() : "higuser");
		        // execute SP
		        storedProcedure.execute();
		        errorCode = new Integer(storedProcedure.getOutputParameterValue("errorcode").toString());
		        
//		        storedProcedure.getOutputParameterValue("errormessage").toString();
		        
		        if (errorCode > 0) {
		        	errorFlg = true;
		        	l_caseID = l_caseID + ", " + cases.getCaseId();
		        }
			}
			
			
		} else if ("serviceRep".equals(caseManagement.getFormType())) {
				for(CaseID cases :caseManagement.getCases())
				{
					StoredProcedureQuery storedProcedure = getEntityManager.fetchEntityManager().createStoredProcedureQuery("CM_submit_service_rep");
					// set parameters
			        storedProcedure.registerStoredProcedureParameter("pcaseid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pcurrentservicerepid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewsalesrepid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewservicerepid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewsalesofficeid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("puserid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("errorcode", Integer.class, ParameterMode.OUT);
			        storedProcedure.registerStoredProcedureParameter("errormessage", String.class, ParameterMode.OUT);
			        storedProcedure.setParameter("pcaseid", cases.getCaseId());
			        storedProcedure.setParameter("pcurrentservicerepid", caseManagement.getSalesRepID()!=null? caseManagement.getNewSalesOfficeID(): "");
			        storedProcedure.setParameter("pnewsalesrepid", caseManagement.getNewSalesRepID()!=null? caseManagement.getNewSalesRepID(): "");
			        storedProcedure.setParameter("pnewservicerepid", caseManagement.getNewServiceRepID()!=null? caseManagement.getNewServiceRepID(): "");
			        storedProcedure.setParameter("pnewsalesofficeid", caseManagement.getNewSalesOfficeID()!=null? caseManagement.getNewSalesOfficeID(): "");
			        storedProcedure.setParameter("puserid",  caseManagement.getUserId()!=null ? caseManagement.getUserId() : "higuser");
			        // execute SP
			        storedProcedure.execute();
			        errorCode = new Integer(storedProcedure.getOutputParameterValue("errorcode").toString());
//			        storedProcedure.getOutputParameterValue("errormessage").toString();
			        if (errorCode > 0) {
			        	errorFlg = true;
			        	l_caseID = l_caseID + ", " + cases.getCaseId();
			        }
				}
		  
		} else if ("salesOffice".equals(caseManagement.getFormType())) {
			for(CaseID cases :caseManagement.getCases())
			{
				StoredProcedureQuery storedProcedure = getEntityManager.fetchEntityManager().createStoredProcedureQuery("CM_submit_salesoffice");
				// set parameters
		        storedProcedure.registerStoredProcedureParameter("pcaseid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("pcurrentsalesofficeid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("pnewsalesrepid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("pnewservicerepid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("pnewsalesofficeid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("pnewunderwriterid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("puserid", String.class, ParameterMode.IN);
		        storedProcedure.registerStoredProcedureParameter("errorcode", Integer.class, ParameterMode.OUT);
		        storedProcedure.registerStoredProcedureParameter("errormessage", String.class, ParameterMode.OUT);
		        storedProcedure.setParameter("pcaseid", cases.getCaseId());
		        storedProcedure.setParameter("pcurrentsalesofficeid", caseManagement.getSalesRepID()!=null? caseManagement.getSalesRepID(): "");
		        storedProcedure.setParameter("pnewsalesofficeid", caseManagement.getNewSalesOfficeID()!=null? caseManagement.getNewSalesOfficeID(): "");
		        storedProcedure.setParameter("pnewsalesrepid", caseManagement.getNewSalesRepID()!=null? caseManagement.getNewSalesRepID(): "");
		        storedProcedure.setParameter("pnewservicerepid", caseManagement.getNewServiceRepID()!=null? caseManagement.getNewServiceRepID(): "");
		        storedProcedure.setParameter("pnewunderwriterid", caseManagement.getNewUndewriterID()!=null? caseManagement.getNewUndewriterID(): "");
		        storedProcedure.setParameter("puserid",  caseManagement.getUserId()!=null ? caseManagement.getUserId() : "higuser");
		        // execute SP
		        storedProcedure.execute();
		        errorCode = new Integer(storedProcedure.getOutputParameterValue("errorcode").toString());
//		        storedProcedure.getOutputParameterValue("errormessage").toString();
		        if (errorCode > 0) {
		        	errorFlg = true;
		        	l_caseID = l_caseID + ", " + cases.getCaseId();
		        }
			}
		  			
		} else if ("producer".equals(caseManagement.getFormType())) {
				for(CaseID cases :caseManagement.getCases())
				{
					StoredProcedureQuery storedProcedure = getEntityManager.fetchEntityManager().createStoredProcedureQuery("CM_submit_producer");
					// set parameters
			        storedProcedure.registerStoredProcedureParameter("pcaseid", String.class, ParameterMode.IN);
//			        storedProcedure.registerStoredProcedureParameter("pcurrentsalesrepid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewsalesrepid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewsalesofficeid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewservicerepid", String.class, ParameterMode.IN);
			       
			        storedProcedure.registerStoredProcedureParameter("puserid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("errorcode", Integer.class, ParameterMode.OUT);
			        storedProcedure.registerStoredProcedureParameter("errormessage", String.class, ParameterMode.OUT);
			        storedProcedure.setParameter("pcaseid", cases.getCaseId());
			        storedProcedure.setParameter("pnewsalesrepid", caseManagement.getNewSalesRepID()!=null? caseManagement.getNewSalesRepID(): "");
			        storedProcedure.setParameter("pnewservicerepid", caseManagement.getNewServiceRepID()!=null? caseManagement.getNewServiceRepID(): "");
			        storedProcedure.setParameter("pnewsalesofficeid", caseManagement.getNewSalesOfficeID()!=null? caseManagement.getNewSalesOfficeID(): "");
			        storedProcedure.setParameter("puserid", caseManagement.getUserId()!=null ? caseManagement.getUserId() : "higuser");
			        // execute SP
			        storedProcedure.execute();
			        errorCode = new Integer(storedProcedure.getOutputParameterValue("errorcode").toString());
//			        storedProcedure.getOutputParameterValue("errormessage").toString();
			        if (errorCode > 0) {
			        	errorFlg = true;
			        	l_caseID = l_caseID + ", " + cases.getCaseId();
			        }
				}
			
		} else if ("underWriter".equals(caseManagement.getFormType())) {
				for(CaseID cases :caseManagement.getCases())
				{
					StoredProcedureQuery storedProcedure = getEntityManager.fetchEntityManager().createStoredProcedureQuery("CM_submit_underwriter");
					// set parameters
//					System.out.println("CaseService.updateCaseManagement() pcaseid " + cases.getCaseId());
					
			        storedProcedure.registerStoredProcedureParameter("pcaseid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewsalesrepid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewsalesofficeid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewunderwriter", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewstateuw", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("pnewprimaryserviceteam", String.class, ParameterMode.IN);
			        
			        storedProcedure.registerStoredProcedureParameter("puserid", String.class, ParameterMode.IN);
			        storedProcedure.registerStoredProcedureParameter("errorcode", Integer.class, ParameterMode.OUT);
			        storedProcedure.registerStoredProcedureParameter("errormessage", String.class, ParameterMode.OUT);
			        storedProcedure.setParameter("pcaseid", cases.getCaseId());
			        storedProcedure.setParameter("pnewsalesrepid", caseManagement.getCurrentsalesrepid()!=null? caseManagement.getCurrentsalesrepid(): "");
			        storedProcedure.setParameter("pnewsalesofficeid", caseManagement.getNewSalesOfficeID()!=null? caseManagement.getNewSalesOfficeID(): "");
			        storedProcedure.setParameter("pnewunderwriter", caseManagement.getNewUndewriterID()!=null? caseManagement.getNewUndewriterID(): "");
			        storedProcedure.setParameter("pnewstateuw", caseManagement.getNewstateuwID()!=null? caseManagement.getNewstateuwID(): "");
			        storedProcedure.setParameter("pnewprimaryserviceteam", caseManagement.getNewSalesRepID()!=null? caseManagement.getNewSalesRepID(): "");

			        storedProcedure.setParameter("puserid", caseManagement.getUserId()!=null ? caseManagement.getUserId() : "higuser");
			        // execute SP
			        storedProcedure.execute();
			        errorCode = new Integer(storedProcedure.getOutputParameterValue("errorcode").toString());
//			        System.out.println("CaseService.updateCaseManagement() error code = " + errorCode);
//			        storedProcedure.getOutputParameterValue("errormessage").toString();
			        if (errorCode > 0) {
			        	errorFlg = true;
			        	l_caseID = l_caseID + ", " + cases.getCaseId();
			        }
				}
		  
		}
		
		CaseManagementResponse respMessage = new CaseManagementResponse();
		if (!errorFlg) {
			respMessage.setMessage("Cases updated successfully !");
			respMessage.setStatusCode("200");	
		} else {
			respMessage.setStatusCode("100");	
			respMessage.setMessage("Case(s) " + l_caseID + " not updated");
		}

		return respMessage;
	}
	
}