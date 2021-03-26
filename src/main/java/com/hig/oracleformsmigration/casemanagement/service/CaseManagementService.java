package com.hig.oracleformsmigration.casemanagement.service;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hig.oracleformsmigration.casemanagement.model.CaseManagementData;
import com.hig.oracleformsmigration.casemanagement.model.ViewGroupSalesOffice;
import com.hig.oracleformsmigration.casemanagement.model.ViewHigAllRep;
import com.hig.oracleformsmigration.casemanagement.model.CaseStatUnderWriterMaintRelationshipEntityResponse;
import com.hig.oracleformsmigration.casemanagement.model.CaseStatusCode;
import com.hig.oracleformsmigration.casemanagement.model.CmGetUnderwriterCase;
import com.hig.oracleformsmigration.casemanagement.model.CoverageProvisionOptionEntity;

import com.hig.oracleformsmigration.casemanagement.model.ProducerResponse;
import com.hig.oracleformsmigration.casemanagement.model.StateCodesEntity;
import com.hig.oracleformsmigration.casemanagement.model.Vendor;
import com.hig.oracleformsmigration.casemanagement.model.ViewCaseProducerUndrwrtr;
import com.hig.oracleformsmigration.casemanagement.model.ViewCmUnderwriterMaint;
import com.hig.oracleformsmigration.casemanagement.model.ViewGloMod;
import com.hig.oracleformsmigration.casemanagement.model.ViewHigRep;
import com.hig.oracleformsmigration.casemanagement.model.ViewPolicyNumberUndrwrtr;
import com.hig.oracleformsmigration.casemanagement.model.ViewStatUnderwriter;

import com.hig.oracleformsmigration.repository.CaseManagementRepository;

import com.hig.oracleformsmigration.repository.CaseStatUnderWriterMainRelationshipRepository;
import com.hig.oracleformsmigration.repository.HIGQueryRepository;

//import com.hig.oracleformsmigration.repository.MigrationRepository;
//import com.hig.oracleformsmigration.repository.MyTableRepository;

import com.hig.oracleformsmigration.repository.StateCodesRepository;
import com.hig.oracleformsmigration.repository.VendorRepository;
import com.hig.oracleformsmigration.casemanagement.model.ViewCaseProducerUndrwrtr;
import com.hig.oracleformsmigration.repository.ViewCaseProducerUndrwrtrRepository;
import com.hig.oracleformsmigration.repository.ViewGroupSalesOfficeRepository;
import com.hig.oracleformsmigration.repository.ViewHigAllRepRepository;
import com.hig.oracleformsmigration.repository.ViewPolicyNumberUndrwrtrRepository;
import com.hig.oracleformsmigration.repository.ViewCmUnderwriterRepository;
import com.hig.oracleformsmigration.repository.ViewGloModRepository;
import com.hig.oracleformsmigration.repository.ViewStatUnderwriterRepository;


import com.hig.oracleformsmigration.util.GetConnection;
import com.hig.oracleformsmigration.util.GetEntityManager;

//import oracle.jdbc.OracleTypes;


import com.hig.oracleformsmigration.repository.CaseStatUnderWriterRelationshipRepository;
import com.hig.oracleformsmigration.repository.CaseStatusCodeRepository;
import com.hig.oracleformsmigration.repository.CoverageProvisionOptionRepository;


@Service
public class CaseManagementService  {

	
	@Autowired
	private ViewGroupSalesOfficeRepository viewGroupSalesOfficeRepository;
	@Autowired
	private HIGQueryRepository higcrud;
	@Autowired
	private ViewCmUnderwriterRepository viewCmUnderwriterRepository;
	@Autowired
	private ViewStatUnderwriterRepository viewStatUnderwriterRepository;
	@Autowired
	private ViewGloModRepository viewGloModRepository;
	@Autowired
	private CoverageProvisionOptionRepository coverageProvisionOption;
	@Autowired
	private StateCodesRepository stateCodesRepository;
	@Autowired
	private CaseStatUnderWriterMainRelationshipRepository caseStatUnderWriterMainRelationshipRepository;
	@Autowired
	private CaseStatusCodeRepository caseStatusCodeRepository;
	@Autowired
	private ViewPolicyNumberUndrwrtrRepository viewPolicyNumberUndrwrtrRepository;
	@Autowired
	private VendorRepository vendorRepository;
	@Autowired
	private ViewCaseProducerUndrwrtrRepository viewCaseProducerUndrwrtr1Repository;
	
	@Autowired
	private ViewHigAllRepRepository viewHigAllRepRepository;
	  
	@Transactional
	public List<ViewGloMod> getGloMod(String salesrep){ 
		return viewGloModRepository.getGloMod(salesrep); 
	}
	
	@Transactional
	public List<ViewGloMod> getGloModByServiceRep(String servicerep){ 
		return viewGloModRepository.getGloModByServiceRep(servicerep); 
	}
	/*
	 * @Transactional public List<ViewGloMod> getGloModByServiceRep(){ return
	 * viewGloModRepository.getGloModByServiceRepCases(); }
	 */
	
	@Transactional
	public List<ViewGloMod> getGloModBySalesOffice(String salesoffice){ 
		return viewGloModRepository.getGloModBySalesOffice(salesoffice); 
	}
	
	@Transactional
	public List<ViewGloMod> getGloModByProducerAndSalesOffice(String producer, String salesoffice){ 
		return viewGloModRepository.getGloModByProducerAndSalesOffice(producer,salesoffice); 
	}
	
	
	 @Transactional 
	 public List<ViewHigAllRep> getViewHighServiceRepSVC(){
		 List<String> ids = new ArrayList<String>(); 
		 ids.add("SVC"); 
		 return viewHigAllRepRepository.getViewHighAllSalesRepSVC(ids); 
		 }
	
	@Transactional
	public List<ViewHigRep> getViewHighRep1(){
		List<String> ids = new ArrayList<String>();
		ids.add("SLS");
		ids.add("SSLS");
		return higcrud.getViewHigRep(ids);
	}
	
	@Transactional
	public List<ViewHigRep> getNewSalesRep(){
		List<String> ids = new ArrayList<String>();
		ids.add("SLS");
		ids.add("SSLS");
		return higcrud.getNewSalesRep(ids);
	}
	@Transactional
	public List<ViewHigRep> getViewHighSalesRepSVC(){
		List<String> ids = new ArrayList<String>();
		ids.add("SVC");
		return higcrud.getViewHigRep(ids);
	}
	
	@Transactional
	public List<ViewCaseProducerUndrwrtr> getProducerBasedonUW(String underwriters){
        String[] underwritersArray = underwriters.split("~");
        List<String> ids = new ArrayList<String>();
        for (String a : underwritersArray)
            ids.add(a);
	
		return viewCaseProducerUndrwrtr1Repository.getProducerBasedonUW(ids);
	}
	
	@Transactional
	public List<ViewGroupSalesOffice> getSalesOfficeRepsIDNotEquals(){ 
		return viewGroupSalesOfficeRepository.getSalesOfficeRepsIDNotEquals(); 
	}
	
	@Transactional
	public List<ViewCmUnderwriterMaint> getUnderWriterDetails(){ 
		return viewCmUnderwriterRepository.getUnderWriterDetails(); 
	}
	
	@Transactional
	public List<ViewStatUnderwriter> getStatUnderWriterDetails(){ 
		return viewStatUnderwriterRepository.getStatUnderWriterDetails(); 
	}
	
	public List<CoverageProvisionOptionEntity> getCoverageProvisionOption(){
		List<CoverageProvisionOptionEntity> ltEmp = coverageProvisionOption.getCoverageProvisionOptionEntity();
		return ltEmp;
	}
	
	public List<CoverageProvisionOptionEntity> getCoverageProvisionOptionAdditionalServiceTeam(){
		List<CoverageProvisionOptionEntity> ltEmp = coverageProvisionOption.getCoverageProvisionOptionAdditionalServiceTeam();
		return ltEmp;
	}
	
	public List<CoverageProvisionOptionEntity> getCoverageProvisionOptionCaseLabel(){
		List<CoverageProvisionOptionEntity> ltEmp = coverageProvisionOption.getCoverageProvisionOptionCaseLabel();
		return ltEmp;
	}
	
	public List<StateCodesEntity> getStateCodes(){
		List<StateCodesEntity> ltEmp = stateCodesRepository.getStateCodes();
		return ltEmp;
	}
	
	
	public List<CaseStatUnderWriterMaintRelationshipEntityResponse> getJoinInformation(){
		List<CaseStatUnderWriterMaintRelationshipEntityResponse> ltEmp = caseStatUnderWriterMainRelationshipRepository.getJoinInformation();
		return ltEmp;
	}
	
	public List<CaseStatusCode> getStatusCode(){
		List<CaseStatusCode> ltEmp = caseStatusCodeRepository.getStatusCode();
		return ltEmp;
	}
	public List<ViewPolicyNumberUndrwrtr> getViewPolicyNumber(String underwriters){
        String[] underwritersArray = underwriters.split("~");
        List<String> ids = new ArrayList<String>();
        for (String a : underwritersArray)
            ids.add(a);
		List<ViewPolicyNumberUndrwrtr> ltEmp = viewPolicyNumberUndrwrtrRepository.getViewPolicyNumber(ids);
		return ltEmp;
	}
	public List<Vendor> getVendor(){
		List<Vendor> ltEmp = vendorRepository.getVendor();
		return ltEmp;
	}
		
		public List<ProducerResponse> cmGetUnderWritersp(CmGetUnderwriterCase cmGetUnderwriterCase) throws SQLException {
		ProducerResponse respMessage ;
		 List<ProducerResponse> underWriterResponse = new ArrayList<ProducerResponse>();
        try {
			Connection con = GetConnection.getDBConnection();
			CallableStatement cs = con.prepareCall("call CM_GET_UNDERWRITER_CASE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			cs.setString(1, cmGetUnderwriterCase.getpVuw() !=null ? cmGetUnderwriterCase.getpVuw().replace("~", "','"): null);
			cs.setString(2, cmGetUnderwriterCase.getpVso1()!=null ? cmGetUnderwriterCase.getpVso1().replace("~", "','"): null);
			cs.setString(3, cmGetUnderwriterCase.getpPrd1() !=null ? cmGetUnderwriterCase.getpPrd1().replace("~", "','") : null );
			cs.setString(4, cmGetUnderwriterCase.getpSl1() !=null ? cmGetUnderwriterCase.getpSl1().replace("~", "','"): null);
			cs.setString(5, cmGetUnderwriterCase.getpSv1() !=null ? cmGetUnderwriterCase.getpSv1().replace("~", "','"): null);
			cs.setString(6, cmGetUnderwriterCase.getpSt1() !=null ? cmGetUnderwriterCase.getpSt1().replace("~", "','"): null);
			cs.setString(7, cmGetUnderwriterCase.getpPr1() !=null ? cmGetUnderwriterCase.getpPr1().replace("~", "','"): null);
			cs.setString(8, cmGetUnderwriterCase.getpAd1() !=null ? cmGetUnderwriterCase.getpAd1().replace("~", "','"): null);
			cs.setString(9, cmGetUnderwriterCase.getpCl1() !=null ? cmGetUnderwriterCase.getpCl1().replace("~", "','"): null);
			cs.setString(10, cmGetUnderwriterCase.getpSs() !=null ? cmGetUnderwriterCase.getpSs().replace("~", "','"): null);
			cs.setString(11, cmGetUnderwriterCase.getpPn1() !=null ? cmGetUnderwriterCase.getpPn1().replace("~", "','"): null);
			cs.setString(12, cmGetUnderwriterCase.getpCs1() !=null ? cmGetUnderwriterCase.getpCs1().replace("~", "','"): null);
			cs.registerOutParameter(13, Types.REF_CURSOR);
			cs.registerOutParameter(14, java.sql.Types.VARCHAR);
			cs.registerOutParameter(15, java.sql.Types.VARCHAR);
			cs.execute();
			//respMessage.setMessage(String.valueOf(cs.getInt("errorcode")));
	        //respMessage.setStatusCode(cs.getString("errormessage"));
			Object obj = cs.getObject(13);
			ResultSet rs = (ResultSet)obj;
			
			while (rs.next()) {
				//if (rs.getString(1) == null) {
				respMessage = new ProducerResponse();
				System.out.println("CaseManagementService.cmGetUnderWritersp() " + rs.getString(1));
				respMessage.setCaseId(rs.getString(1)!=null? rs.getString(1): "");
				respMessage.setCaseName(rs.getString(2)!=null? rs.getString(2): "");
				respMessage.setProducer(rs.getString(3)!=null? rs.getString(3): "");
				respMessage.setSalesOffice(rs.getString(4)!=null? rs.getString(4): "");
				respMessage.setUnderWriter(rs.getString(5)!=null? rs.getString(5): "");
				respMessage.setUndrWrtr(rs.getString(6)!=null? rs.getString(6): "");
				respMessage.setSalesRep(rs.getString(7)!=null? rs.getString(7): "");
				respMessage.setStatUnderwriter(rs.getString(8)!=null? rs.getString(8): "");
				respMessage.setPsTeam(rs.getString(9)!=null? rs.getString(9): "");
				underWriterResponse.add(respMessage);
			}
			
			rs.close();
			cs.close();
			GetConnection.closeDBConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
        
        return underWriterResponse;
	}
}
