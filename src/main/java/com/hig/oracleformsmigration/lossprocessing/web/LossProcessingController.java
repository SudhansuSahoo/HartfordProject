package com.hig.oracleformsmigration.lossprocessing.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hig.oracleformsmigration.lossprocessing.service.LossProcessingService;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistributionList;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReport;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReportBasedOnSponsorID;
import com.hig.oracleformsmigration.lossprocessing.model.PlBenefitLog;
import com.hig.oracleformsmigration.lossprocessing.model.PlBenefitLogResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlCorrectionLog;
import com.hig.oracleformsmigration.lossprocessing.model.PlCorrectionResponseLog;
import com.hig.oracleformsmigration.lossprocessing.model.Sponsor;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorPolicy;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorPolicyResponse;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorResponse;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorTaxListResponse;
import com.hig.oracleformsmigration.lossprocessing.model.BatchSponsorDistributionReportRelationship;
import com.hig.oracleformsmigration.lossprocessing.model.BenefitDescription;
import com.hig.oracleformsmigration.lossprocessing.model.CaseManagementResponse;
import com.hig.oracleformsmigration.lossprocessing.model.LpGetBenefitDtlsRequest;
import com.hig.oracleformsmigration.lossprocessing.model.LpGetBenefitDtlsResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistList;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistributionEmailReport;

@CrossOrigin
@RestController
@RequestMapping("/lossprocessing")
public class LossProcessingController {

	@Autowired
	LossProcessingService lossprocessingService;
	
	@GetMapping("/getSponsorNames")
	public List<Sponsor> getSponsor(){
		List<Sponsor> ltEmp = lossprocessingService.getSponsor();
		return ltEmp;
	}
	
	@GetMapping("/getReport/{sponsorID}")
	public List<PlBatchSponsorReportBasedOnSponsorID> getBasedOnSponsorSelected(@PathVariable String sponsorID) throws SQLException{
		List<PlBatchSponsorReportBasedOnSponsorID> ltEmp = lossprocessingService.getBasedOnSponsorSelected(sponsorID);
		return ltEmp;
	}
	@GetMapping("/getReportDL/{emailID}")
	public List<PlBatchReportDistributionEmailReport> getReportDL(@PathVariable String emailID){
		System.out.println("emailID>>" +emailID);
		List<PlBatchReportDistributionEmailReport> ltEmp = lossprocessingService.getReportDL(emailID);
		return ltEmp;
	}
	
	@GetMapping("/getEmailReceipient/{emailID}")
	public List<BatchSponsorDistributionReportRelationship> getBatchSponsorDistributionReportRelationship(@PathVariable String emailID){
		List<BatchSponsorDistributionReportRelationship> ltEmp = lossprocessingService.getBatchSponsorDistributionReportRelationship(emailID);
		return ltEmp;
	}
	
	
	@GetMapping("/getSponsor")
	public List<SponsorResponse> getSponsorBasedOnCaseReport(){
		List<SponsorResponse> ltEmp = lossprocessingService.getSponsorBasedOnCaseReport();
		return ltEmp;
	}
	

	@RequestMapping(value = "/addDelMailID", method = RequestMethod.POST)
	public CaseManagementResponse saveInsDelMailDistsp(@RequestBody PlBatchReportDistList insDelMailDist) {
		return lossprocessingService.saveInsDelMailDistsp(insDelMailDist);
	}

	@RequestMapping(value = "/getPolicyByPolicy", method = RequestMethod.POST)
	public SponsorPolicyResponse cmgetSponsorPolicysp(@RequestBody SponsorPolicy sponsorPolicy) throws Exception {
		return lossprocessingService.getSponsorPolicysp(sponsorPolicy);
	}
	@RequestMapping(value = "/getHIGPolicyByPolicy", method = RequestMethod.POST)
	public SponsorPolicyResponse cmgetSponsorhigPolicyspsp(@RequestBody SponsorPolicy sponsorPolicy) throws Exception {
		return lossprocessingService.getSponsorhigPolicysp(sponsorPolicy);
	}
	@RequestMapping(value = "/getBenefitDetails", method = RequestMethod.POST)
	public LpGetBenefitDtlsResponse cmLpGetBenefitDtlssp(@RequestBody LpGetBenefitDtlsRequest lpGetBenefitDtlsRequest) throws SQLException {
		return lossprocessingService.cmLpGetBenefitDtlssp(lpGetBenefitDtlsRequest);
	}
	@RequestMapping(value = "/addBenefitLog", method = RequestMethod.POST)
	public PlBenefitLogResponse plBenefitInsertLogsp(@RequestBody PlBenefitLog plBenefitLog) throws SQLException {
		return lossprocessingService.plBenefitInsertLogsp(plBenefitLog);
	}
	
	@GetMapping(value = "/deleteBenefitLog/{plogid}")
	public PlBenefitLogResponse deletePlBenefitLog(@PathVariable String plogid) throws Exception {
		return lossprocessingService.deletePlBenefitLog(plogid);
	}
	
	
	@RequestMapping(value = "/getSponsorTax", method = RequestMethod.POST)
	public SponsorTaxListResponse getSponsorTaxListsp() throws Exception {
		return lossprocessingService.getSponsorTaxListsp();
	}

	@GetMapping("/getBenefitDescription/{id}")
	public List<BenefitDescription> getBenefitDescription(@PathVariable String id) throws SQLException{
		List<BenefitDescription> ltEmp = lossprocessingService.getBenefitCode(id);
		//return new ResponseEntity<>(ltEmp, HttpStatus.OK);
		return ltEmp;
		}
	
	@RequestMapping(value = "/getBenefitCorrectionDetails", method = RequestMethod.POST)
	public PlCorrectionResponseLog cmLpGetCorrectionLogDetail(@RequestBody PlCorrectionLog plCorrectionLog) throws SQLException {
		return lossprocessingService.cmLpGetCorrectionLogDetail(plCorrectionLog);
	}
}
