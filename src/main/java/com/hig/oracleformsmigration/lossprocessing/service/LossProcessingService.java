package com.hig.oracleformsmigration.lossprocessing.service;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hig.oracleformsmigration.lossprocessing.model.BatchSponsorDistributionReportRelationship;
import com.hig.oracleformsmigration.lossprocessing.model.BenefitDescription;
import com.hig.oracleformsmigration.repository.BenefitDescriptionDetailsRepository;
import com.hig.oracleformsmigration.lossprocessing.model.CaseManagementResponse;
import com.hig.oracleformsmigration.lossprocessing.model.LpGetBenefitDtlsRequest;
import com.hig.oracleformsmigration.lossprocessing.model.LpGetBenefitDtlsResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistList;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistributionEmailReport;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistributionList;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReport;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReportBasedOnSponsorID;
import com.hig.oracleformsmigration.lossprocessing.model.PlBenefitLog;
import com.hig.oracleformsmigration.lossprocessing.model.PlBenefitLogResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlCorrectionLog;
import com.hig.oracleformsmigration.lossprocessing.model.PlCorrectionResponseLog;
import com.hig.oracleformsmigration.lossprocessing.model.PolicyCursor;
import com.hig.oracleformsmigration.lossprocessing.model.PolicyDetails;
import com.hig.oracleformsmigration.lossprocessing.model.Sponsor;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorPolicy;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorPolicyResponse;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorResponse;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorTaxListResponse;
import com.hig.oracleformsmigration.repository.BatchSponsorDistributionReportRelationshipRepository;
import com.hig.oracleformsmigration.repository.CaseManagementRepository;
import com.hig.oracleformsmigration.repository.CaseReportRequestRepository;
import com.hig.oracleformsmigration.repository.CaseStatUnderWriterMainRelationshipRepository;
import com.hig.oracleformsmigration.repository.CaseStatusCodeRepository;
import com.hig.oracleformsmigration.repository.PlBatchReportDistListRepository;
//import com.hig.oracleformsmigration.repository.PlBatchSponsorReportBasedOnSponsorIDResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReportBasedOnSponsorIDResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlBenefitLogResponse;
import com.hig.oracleformsmigration.repository.PlBatchSponsorReportRepository;
import com.hig.oracleformsmigration.repository.SponsorRepository;
import com.hig.oracleformsmigration.repository.ViewPolicyNumberUndrwrtrRepository;
import com.hig.oracleformsmigration.repository.PLBenefitLogDeleteRepository;
import com.hig.oracleformsmigration.util.GetConnection;
import com.hig.oracleformsmigration.util.GetEntityManager;


@Service
public class LossProcessingService  {

	@Autowired
	private GetEntityManager getEntityManager;
	@Autowired
	private SponsorRepository sponsorRepository;
	@Autowired
	private PlBatchSponsorReportRepository plBatchSponsorReportRepository;
	@Autowired
	private PlBatchReportDistListRepository plBatchReportDistListRepository;
	@Autowired
	private BatchSponsorDistributionReportRelationshipRepository batchSponsorDistributionReportRelationshipRepository;
	@Autowired
	private CaseReportRequestRepository caseReportRequestRepository;
	@Autowired 
	private PLBenefitLogDeleteRepository PLBenefitLogDeleteRepository;
	@Autowired
	private BenefitDescriptionDetailsRepository benefitDescriptionDetailsRepository;
	
	
	
	public List<Sponsor> getSponsor(){
		List<Sponsor> ltEmp = sponsorRepository.getSponsor();
		return ltEmp;
	}
	public List<PlBatchSponsorReportBasedOnSponsorID> getBasedOnSponsorSelected(String sponsorID){
		String format = "";
		int formatLength = 18-sponsorID.length();
		for (int i=1;i<=formatLength;i++)
			format=format+" ";
		List<PlBatchSponsorReportBasedOnSponsorID> ltEmp = plBatchSponsorReportRepository.getBasedOnSponsorSelected(sponsorID+format);
		return ltEmp;
	}
	public List<PlBatchReportDistributionEmailReport> getReportDL(String emailId){
		List<PlBatchReportDistributionEmailReport> ltEmp = plBatchReportDistListRepository.getReportDL(emailId);
		return ltEmp;
	}
	public List<BatchSponsorDistributionReportRelationship> getBatchSponsorDistributionReportRelationship(String emailID){
		
		
		List<BatchSponsorDistributionReportRelationship> ltEmp = batchSponsorDistributionReportRelationshipRepository.getBatchSponsorDistributionReportRelationship(emailID);
		return ltEmp;
	}
	
	public List<SponsorResponse> getSponsorBasedOnCaseReport(){
		List<SponsorResponse> ltEmp = caseReportRequestRepository.getSponsorBasedOnCaseReport();
		return ltEmp;
	}

	@Transactional
	public CaseManagementResponse saveInsDelMailDistsp(PlBatchReportDistList insDelMailDist) {
		
		CaseManagementResponse respMessage = new CaseManagementResponse();
		StoredProcedureQuery storedProcedure = getEntityManager.fetchEntityManager().createStoredProcedureQuery("LP_INS_DEL_MAILDIST");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("pmailid", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pmaildistribution", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("puserid", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("paction", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("errorcode", Integer.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("errormessage", String.class, ParameterMode.OUT);
        
        storedProcedure.setParameter("pmailid", insDelMailDist.getPmailid());//EMLDSTNTN//pmailid
        storedProcedure.setParameter("pmaildistribution", insDelMailDist.getPmaildistribution());//USRNM//pmaildistribution
        storedProcedure.setParameter("puserid", insDelMailDist.getPuserid());//PRCSRID//puserid
        storedProcedure.setParameter("paction", insDelMailDist.getPaction());//EMLTYPCD//paction
        // execute SP
        storedProcedure.execute();
		respMessage.setStatusCode(storedProcedure.getOutputParameterValue("errorcode").toString());
		if (insDelMailDist.getPaction().equals("I")) {
			respMessage.setMessage(storedProcedure.getOutputParameterValue("errormessage").toString());
			}
		else {
			respMessage.setMessage(storedProcedure.getOutputParameterValue("errormessage").toString());
		}
		
		return respMessage;
	}
	

	public LpGetBenefitDtlsResponse cmLpGetBenefitDtlssp(LpGetBenefitDtlsRequest lpGetBenefitDtlsRequest) {
		LpGetBenefitDtlsResponse respMessage = new LpGetBenefitDtlsResponse();
		StoredProcedureQuery storedProcedure = getEntityManager.fetchEntityManager().createStoredProcedureQuery("LP_GET_BENEFIT_DTLS");
		// set parameters
        storedProcedure.registerStoredProcedureParameter("ppolicyno", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("ppolicynotype", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pcheckno", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("peftno", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("psptxnno", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pcheckamt", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("psponsorid", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("psponsorname", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("ppolicyholdername", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pinsuredname", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pinsuredssn", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD1", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT1", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC1", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD2", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT2", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC2", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD3", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT3", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC3", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD4", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT4", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC4", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD5", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT5", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC5", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD6", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT6", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC6", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD7", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT7", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC7", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD8", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT8", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC8", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("errorcode", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("errormessage", String.class, ParameterMode.OUT);
       
        storedProcedure.setParameter("ppolicyno", lpGetBenefitDtlsRequest.getPpolicyno());
        storedProcedure.setParameter("ppolicynotype", lpGetBenefitDtlsRequest.getPpolicynotype());
        storedProcedure.setParameter("pcheckno", lpGetBenefitDtlsRequest.getPcheckno());
        storedProcedure.setParameter("peftno", lpGetBenefitDtlsRequest.getPeftno());
        storedProcedure.setParameter("psptxnno", lpGetBenefitDtlsRequest.getPsptxnno());
        // execute SP
        storedProcedure.execute();
        //respMessage.setMessage(storedProcedure.getOutputParameterValue("errorcode").toString());
        //respMessage.setMessage(storedProcedure.getOutputParameterValue("errormessage").toString());
        
        return respMessage;
	}
	
	public SponsorPolicyResponse getSponsorPolicysp(SponsorPolicy sponsorPolicy) throws SQLException {
		SponsorPolicyResponse respMessage = new SponsorPolicyResponse();
		PolicyCursor policy = new PolicyCursor();	
		try {
			Connection con = GetConnection.getDBConnection();
			CallableStatement cs = con.prepareCall("call LP_GET_REPORT_POLICYNO(?,?,?,?,?)");
			//Set the values to params
			cs.setString(1, sponsorPolicy.getpSponsor());
			cs.setString(2, sponsorPolicy.getpMode());
			cs.registerOutParameter(3, Types.REF_CURSOR);
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);
			cs.registerOutParameter(5, java.sql.Types.VARCHAR);
			cs.execute();
	        respMessage.setErrorCode(cs.getString(4)!=null? cs.getString(4): "");
			respMessage.setErrorMessage(cs.getString(5)!=null? cs.getString(5): "");
	        
			Object obj = cs.getObject(3);
			ResultSet rs = (ResultSet)obj;
			
			while (rs.next()) {
				policy.setPrvtlblplcynbrn(rs.getString(1));
				policy.setPrvtlblplcynbrm(rs.getString(2));
			}
			respMessage.setPolicyCursor(policy);
			
			rs.close();
			cs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        return respMessage;
	}
	public SponsorPolicyResponse getSponsorhigPolicysp(SponsorPolicy sponsorPolicy) throws SQLException {
		SponsorPolicyResponse respMessage = new SponsorPolicyResponse();
		PolicyCursor policy = new PolicyCursor();
		try {
			Connection con = GetConnection.getDBConnection();
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_GET_REPORT_HIGPOLICYNO(?,?,?,?,?)");
			//Set the values to params
			cs.setString(1, sponsorPolicy.getpSponsor());
			cs.setString(2, sponsorPolicy.getpMode());
			cs.registerOutParameter(3, Types.REF_CURSOR);
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);
			cs.registerOutParameter(5, java.sql.Types.VARCHAR);
			cs.execute();
			respMessage.setErrorCode(cs.getString(4)!=null? cs.getString(4): "");
			respMessage.setErrorMessage(cs.getString(5)!=null? cs.getString(5): "");
			
			Object obj = cs.getObject(3);
			ResultSet rs = (ResultSet)obj;
			
			while (rs.next()) {
				policy.setPrvtlblplcynbrn(rs.getString(1));
				policy.setPrvtlblplcynbrm(rs.getString(2));
			}
			respMessage.setPolicyCursor(policy);
			rs.close();
			cs.close();
			GetConnection.closeDBConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
        return respMessage;
	}
	
	public PlBenefitLogResponse plBenefitInsertLogsp(PlBenefitLog plBenefitLog) throws SQLException {
		PlBenefitLogResponse respMessage = new PlBenefitLogResponse();
        
		try {
			Connection con = GetConnection.getDBConnection();
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_insertBenefitLog(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//cs.registerOutParameter(12, OracleTypes.CURSOR);
			//Set the values to params
			cs.setString(1, plBenefitLog.getPpolicyno());
			cs.setString(2, plBenefitLog.getPpolicynotype());
			cs.setString(3, plBenefitLog.getPcheckno());
			cs.setString(4, plBenefitLog.getPeftno());
			cs.setString(5, plBenefitLog.getPsptxnno());
			cs.setInt(6, plBenefitLog.getPcheckamt());
			cs.setString(7, plBenefitLog.getPsponsorid());
			cs.setString(8, plBenefitLog.getPsponsorname());
			cs.setString(9, plBenefitLog.getPpolicyholdername());
			cs.setString(10, plBenefitLog.getPinsuredname());
			cs.setString(11, plBenefitLog.getPinsuredssn());
			cs.setString(12, plBenefitLog.getpBNFTCD1());
			cs.setInt(13, plBenefitLog.getpBNFTAMT1());
			cs.setString(14, plBenefitLog.getBNFTDSC1());
			cs.setString(15, plBenefitLog.getpBNFTCD2());
			cs.setInt(16, plBenefitLog.getpBNFTAMT2());
			cs.setString(17, plBenefitLog.getBNFTDSC2());
			cs.setString(18, plBenefitLog.getpBNFTCD3());
			cs.setInt(19, plBenefitLog.getpBNFTAMT3());
			cs.setString(20, plBenefitLog.getBNFTDSC3());
			cs.setString(21, plBenefitLog.getpBNFTCD4());
			cs.setInt(22, plBenefitLog.getpBNFTAMT4());
			cs.setString(23, plBenefitLog.getBNFTDSC4());
			cs.setString(24, plBenefitLog.getpBNFTCD5());
			cs.setInt(25, plBenefitLog.getpBNFTAMT5());
			cs.setString(26, plBenefitLog.getBNFTDSC5());
			cs.setString(27, plBenefitLog.getpBNFTCD6());
			cs.setInt(28, plBenefitLog.getpBNFTAMT6());
			cs.setString(29, plBenefitLog.getBNFTDSC6());
			cs.setString(30, plBenefitLog.getpBNFTCD7());
			cs.setInt(31, plBenefitLog.getpBNFTAMT7());
			cs.setString(32, plBenefitLog.getBNFTDSC7());
			cs.setString(33, plBenefitLog.getpBNFTCD8());
			cs.setInt(34, plBenefitLog.getpBNFTAMT8());
			cs.setString(35, plBenefitLog.getBNFTDSC8());
			cs.setString(36, plBenefitLog.getPuserid());
			cs.registerOutParameter(37, java.sql.Types.VARCHAR);
			cs.registerOutParameter(38, java.sql.Types.VARCHAR);
			cs.registerOutParameter(39, java.sql.Types.VARCHAR);
			
			cs.execute();
			respMessage.setPlogid(cs.getString(37));
			respMessage.setErrorcode(cs.getString(38)!=null? cs.getString(38): "");
			respMessage.seterrorMessage(cs.getString(39)!=null? cs.getString(39): "");
			
			GetConnection.closeDBConnection(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return respMessage;
	}
	
	public PlCorrectionResponseLog cmLpGetCorrectionLogDetail(PlCorrectionLog plCorrectionLog) throws SQLException {
		PlCorrectionResponseLog respMessage = new PlCorrectionResponseLog();
		PolicyDetails policyDetailsInternal = new PolicyDetails();
        
		try {
			Connection con = GetConnection.getDBConnection();
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_GET_CORRECTIONLOG_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//Set the values to params
			cs.setString(1, plCorrectionLog.getPlogid());
			cs.setString(2, plCorrectionLog.getPpolicyno());
			cs.setString(3, plCorrectionLog.getPpolicynotype());
			cs.setString(4, plCorrectionLog.getPcheckno());
			cs.setString(5, plCorrectionLog.getPeftno());
			cs.setString(6, plCorrectionLog.getPsptxnno());
			
			cs.registerOutParameter(7, java.sql.Types.INTEGER);
			cs.registerOutParameter(8, java.sql.Types.VARCHAR);
			cs.registerOutParameter(9, java.sql.Types.VARCHAR);
			cs.registerOutParameter(10, java.sql.Types.VARCHAR);
			cs.registerOutParameter(11, java.sql.Types.VARCHAR);
			cs.registerOutParameter(12, java.sql.Types.VARCHAR);
			cs.registerOutParameter(13, Types.REF_CURSOR);
			cs.registerOutParameter(14, java.sql.Types.VARCHAR);
			cs.registerOutParameter(15, java.sql.Types.VARCHAR);			
			
			cs.execute();
			
			respMessage.setPcheckamt(cs.getInt(7));
			respMessage.setPsponsorid(cs.getString(8)!=null? cs.getString(8): "");
			respMessage.setPsponsorname(cs.getString(9)!=null? cs.getString(9): "");
			respMessage.setPpolicyholdername(cs.getString(10)!=null? cs.getString(10): "");
			respMessage.setPinsuredname(cs.getString(11)!=null? cs.getString(11): "");
			respMessage.setPinsuredssn(cs.getString(12)!=null? cs.getString(12): "");
			
			Object obj = cs.getObject(13);
			ResultSet rs = (ResultSet)obj;
					
			while (rs.next()) {
				//desc.add(rs.getString(1));
				policyDetailsInternal.setLOGID(rs.getString(1)!=null? rs.getString(1): "");
				policyDetailsInternal.setPLCYNBR(rs.getString(2)!=null? rs.getString(2): "");
				policyDetailsInternal.setPLCYSYMBLTYP(rs.getString(3)!=null? rs.getString(3): "");
				policyDetailsInternal.setCHCKNBR(rs.getString(4)!=null? rs.getString(4): "");
				policyDetailsInternal.setBACISEFTID(rs.getString(5)!=null? rs.getString(5): "");
				policyDetailsInternal.setBNFTCD1(rs.getString(6)!=null? rs.getString(6): "");
				policyDetailsInternal.setBNFTAMT1(rs.getInt(7)!=0? rs.getInt(7): 0);
				policyDetailsInternal.setBNFTCD2(rs.getString(8)!=null? rs.getString(8): "");
				policyDetailsInternal.setBNFTAMT2(rs.getInt(9)!=0? rs.getInt(9): 0);
				policyDetailsInternal.setBNFTCD3(rs.getString(10)!=null? rs.getString(10): "");
				policyDetailsInternal.setBNFTAMT3(rs.getInt(11)!=0? rs.getInt(11): 0);
				policyDetailsInternal.setBNFTCD4(rs.getString(12)!=null? rs.getString(12): "");
				policyDetailsInternal.setBNFTAMT4(rs.getInt(13)!=0? rs.getInt(13): 0);
				policyDetailsInternal.setBNFTCD5(rs.getString(14)!=null? rs.getString(14): "");
				policyDetailsInternal.setBNFTAMT5(rs.getInt(15)!=0? rs.getInt(15): 0);
				policyDetailsInternal.setBNFTCD6(rs.getString(16)!=null? rs.getString(16): "");
				policyDetailsInternal.setBNFTAMT6(rs.getInt(17)!=0? rs.getInt(17): 0);
				policyDetailsInternal.setBNFTCD7(rs.getString(18)!=null? rs.getString(18): "");
				policyDetailsInternal.setBNFTAMT7(rs.getInt(19)!=0? rs.getInt(19): 0);
				policyDetailsInternal.setBNFTCD8(rs.getString(20)!=null? rs.getString(20): "");
				policyDetailsInternal.setBNFTAMT8(rs.getInt(21)!=0? rs.getInt(21): 0);
				policyDetailsInternal.setPRCSRID(rs.getString(22)!=null? rs.getString(22): "");
				policyDetailsInternal.setPRCSSDTTM(rs.getString(23)!=null? rs.getString(23): "");
				policyDetailsInternal.setSPNSRID(rs.getString(24)!=null? rs.getString(24): "");
				policyDetailsInternal.setUPDTIND(rs.getString(25)!=null? rs.getString(25): "");
			}
			respMessage.setPolicyDetails(policyDetailsInternal);;
			respMessage.setErrorCode(cs.getObject(14).toString());
			respMessage.setErrorMessage(cs.getObject(15).toString());
			cs.close();
			GetConnection.closeDBConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return respMessage;
	}

	@Transactional
	public PlBenefitLogResponse deletePlBenefitLog(String plogId) throws Exception {
		//PLBenefitLogDeleteRepository.deleteById(id);
		
		PlBenefitLogResponse respMessage = new PlBenefitLogResponse();
		List<String> desc = new ArrayList<String>();
		try {
			Connection con = GetConnection.getDBConnection();
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_DEL_BENEFITLOG(?,?,?)");
			//Set the values to params
			cs.setString(1, plogId);
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.execute();
			respMessage.setPlogid(plogId);
			
			
			respMessage.setErrorcode(cs.getObject(2).toString());
			respMessage.seterrorMessage(cs.getString(3)!=null? cs.getString(3): "");
			
			cs.close();
			GetConnection.closeDBConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return respMessage;
		
	}
	public SponsorTaxListResponse getSponsorTaxListsp() throws Exception {
		SponsorTaxListResponse respMessage = new SponsorTaxListResponse();
		List<String> desc = new ArrayList<String>();
		try {
			Connection con = GetConnection.getDBConnection();
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_GET_SPONSORSTAXLIST(?,?,?)");
			//Set the values to params
			cs.registerOutParameter(1, Types.REF_CURSOR);
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.execute();
			Object obj = cs.getObject(1);
			ResultSet rs = (ResultSet)obj;
			respMessage.setErrorCode(Integer.valueOf(cs.getObject(2).toString()));
			respMessage.setErrorMessage(cs.getString(3)!=null? cs.getString(3): "");
			while (rs.next()) {
				desc.add(rs.getString(1));
			}
			respMessage.setDesription(desc);
			
			rs.close();
			cs.close();
			GetConnection.closeDBConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return respMessage;
	}
	@Transactional
	public List<BenefitDescription> getBenefitCode(String id){
		List<BenefitDescription> ltEmp = benefitDescriptionDetailsRepository.getBenefitCode(id);
		return ltEmp;
	}
	
	
}
