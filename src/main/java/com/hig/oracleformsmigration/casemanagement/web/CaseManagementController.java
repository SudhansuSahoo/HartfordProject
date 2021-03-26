package com.hig.oracleformsmigration.casemanagement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hig.oracleformsmigration.casemanagement.service.CaseManagementService;
import com.hig.oracleformsmigration.casemanagement.model.ProducerResponse;
import com.hig.oracleformsmigration.casemanagement.model.StateCodesEntity;
import com.hig.oracleformsmigration.casemanagement.model.Vendor;
import com.hig.oracleformsmigration.casemanagement.model.ViewGloMod;
import com.hig.oracleformsmigration.casemanagement.model.ViewGroupSalesOffice;
import com.hig.oracleformsmigration.casemanagement.model.ViewHigAllRep;
import com.hig.oracleformsmigration.casemanagement.model.ViewHigRep;
import com.hig.oracleformsmigration.casemanagement.model.ViewPolicyNumberUndrwrtr;
import com.hig.oracleformsmigration.casemanagement.model.ViewStatUnderwriter;
import com.hig.oracleformsmigration.service.CaseService;
import com.hig.oracleformsmigration.casemanagement.model.CaseManagement;
import com.hig.oracleformsmigration.casemanagement.model.CaseManagementResponse;
import com.hig.oracleformsmigration.casemanagement.model.CaseStatUnderWriterMaintRelationshipEntityResponse;
import com.hig.oracleformsmigration.casemanagement.model.CaseStatusCode;
import com.hig.oracleformsmigration.casemanagement.model.CmGetUnderwriterCase;
import com.hig.oracleformsmigration.casemanagement.model.CoverageProvisionOptionEntity;
import com.hig.oracleformsmigration.casemanagement.model.ViewCaseProducerUndrwrtr;
import com.hig.oracleformsmigration.casemanagement.model.ViewCmUnderwriterMaint;

@CrossOrigin
@RestController
@RequestMapping("/casemanagement")
public class CaseManagementController {

	@Autowired
	CaseManagementService caseManagementService;
	
	@Autowired
	CaseService caseService;
	
	@PostMapping("/submit")
	public CaseManagementResponse updateCaseManagement(@RequestBody CaseManagement caseManagement) {
		return caseService.updateCaseManagement(caseManagement);
	}
	
	@GetMapping("/getSalesRep")
	public ResponseEntity<Object> getViewHighSalesRep(){
		List<ViewHigRep> ltEmp = caseManagementService.getViewHighRep1();
		return new ResponseEntity<>(ltEmp, HttpStatus.OK);
	}
	
	@GetMapping("/getNewSalesRep")
	public ResponseEntity<Object> getNewSalesRep(){
		List<ViewHigRep> ltEmp = caseManagementService.getNewSalesRep();
		return new ResponseEntity<>(ltEmp, HttpStatus.OK);
	}
	
	@GetMapping("/getServiceRep")
	public ResponseEntity<Object> getViewHighSalesRepSVC(){
		List<ViewHigRep> ltEmp = caseManagementService.getViewHighSalesRepSVC();
		return new ResponseEntity<>(ltEmp, HttpStatus.OK);
	}
	
	@GetMapping("/getSalesOffice")
	public List<ViewGroupSalesOffice> getSalesOfficeRepsIDNotEquals(){
		List<ViewGroupSalesOffice> ltEmp = caseManagementService.getSalesOfficeRepsIDNotEquals();
		return ltEmp;
	}
	
	@GetMapping("/getProducerBasedonUW/{underwriters}")
	public ResponseEntity<Object> getProducerBasedonUW(@PathVariable String underwriters){
		System.out.println("Print underwriters>>>" +underwriters);
		List<ViewCaseProducerUndrwrtr> ltEmp = caseManagementService.getProducerBasedonUW(underwriters);
	return new ResponseEntity<>(ltEmp, HttpStatus.OK);
	}
	
	@GetMapping("/getUnderWriters")
	public ResponseEntity<Object> getUnderWriterDetails(){
		List<ViewCmUnderwriterMaint> ltEmp = caseManagementService.getUnderWriterDetails();
		return new ResponseEntity<>(ltEmp, HttpStatus.OK);
	}
	@GetMapping("/getStatUnderWriterDetails")
	public ResponseEntity<Object> getStatUnderWriterDetails(){
		List<ViewStatUnderwriter> ltEmp = caseManagementService.getStatUnderWriterDetails();
		return new ResponseEntity<>(ltEmp, HttpStatus.OK);
	}
	@GetMapping("/getSalesRepCases/{salesrep}")
	public ResponseEntity<Object> getViewGloModSalesRep(@PathVariable String salesrep){
		List<ViewGloMod> ltEmp = caseManagementService.getGloMod(salesrep);
		return new ResponseEntity<>(ltEmp, HttpStatus.OK);
		
	}
	
	//@GetMapping("/getServiceRepCases")
	//public ResponseEntity<Object> getViewGloModServiceRepCases(){
	//	List<ViewGloMod> ltEmp = caseManagementService.getGloModByServiceRepCases();
	//	return new ResponseEntity<>(ltEmp, HttpStatus.OK);
		
	 @GetMapping("/getServiceRepCases") 
	 public ResponseEntity<Object> getViewHighAllServiceRepSVC(){ 
		 List<ViewHigAllRep> ltEmp = caseManagementService.getViewHighServiceRepSVC(); 
		 return new ResponseEntity<>(ltEmp,	 HttpStatus.OK); }
		
	@GetMapping("/getServiceRepCases/{servicerep}")
	public ResponseEntity<Object> getViewGloModServiceRep(@PathVariable String servicerep){
		List<ViewGloMod> ltEmp = caseManagementService.getGloModByServiceRep(servicerep);
		return new ResponseEntity<>(ltEmp, HttpStatus.OK);
		
	}
	@GetMapping("/getSalesOfficeCases/{salesoffice}")
	public ResponseEntity<Object> getViewGloModSalesOffice(@PathVariable String salesoffice){
		List<ViewGloMod> ltEmp = caseManagementService.getGloModBySalesOffice(salesoffice);
		return new ResponseEntity<>(ltEmp, HttpStatus.OK);
		
	}
	@GetMapping("/getProducerCases")
	public ResponseEntity<Object> getViewGloModSalesOffice(@RequestParam String producer,@RequestParam String salesoffcd){
		List<ViewGloMod> ltEmp = caseManagementService.getGloModByProducerAndSalesOffice(producer,salesoffcd);
		return new ResponseEntity<>(ltEmp, HttpStatus.OK);
		
	}
	@GetMapping("/getPrimaryServiceTeam")
	public List<CoverageProvisionOptionEntity> getCoverageProvisionOption(){
		List<CoverageProvisionOptionEntity> ltEmp = caseManagementService.getCoverageProvisionOption();
		return ltEmp;
	}
	@GetMapping("/getadditionalServiceTeam")
	public List<CoverageProvisionOptionEntity> getCoverageProvisionOptionAdditionalServiceTeam(){
		List<CoverageProvisionOptionEntity> ltEmp = caseManagementService.getCoverageProvisionOptionAdditionalServiceTeam();
		return ltEmp;
	}
	@GetMapping("/getCaseLabel")
	public List<CoverageProvisionOptionEntity> getCoverageProvisionOptionCaseLabel(){
		List<CoverageProvisionOptionEntity> ltEmp = caseManagementService.getCoverageProvisionOptionCaseLabel();
		return ltEmp;
	}
	@GetMapping("/getStateCodes")
	public List<StateCodesEntity> getStateCodes(){
		List<StateCodesEntity> ltEmp = caseManagementService.getStateCodes();
		return ltEmp;
	}
	@GetMapping("/getStatUnderwriters")
	public List<CaseStatUnderWriterMaintRelationshipEntityResponse> getJoinInformation(){
		List<CaseStatUnderWriterMaintRelationshipEntityResponse> ltEmp = caseManagementService.getJoinInformation();
		return ltEmp;
	}
	@GetMapping("/getStatusCode")
	public List<CaseStatusCode> getStatusCode(){
		List<CaseStatusCode> ltEmp = caseManagementService.getStatusCode();
		return ltEmp;
	}

	@GetMapping("/getViewPolicyNumber/{underwriters}")
	public List<ViewPolicyNumberUndrwrtr> getViewPolicyNumber(@PathVariable String underwriters){
		List<ViewPolicyNumberUndrwrtr> ltEmp = caseManagementService.getViewPolicyNumber(underwriters);
		return ltEmp;
	}
	
	@GetMapping("/getVendor")
	public List<Vendor> getVendor(){
		List<Vendor> ltEmp = caseManagementService.getVendor();
		return ltEmp;
	}
	@RequestMapping(value = "/getUnderwriterCases", method = RequestMethod.POST)
	public  List<ProducerResponse> cmSubmitUunderwritersp(@RequestBody CmGetUnderwriterCase cmGetUnderwriterCase) throws Exception {
		return caseManagementService.cmGetUnderWritersp(cmGetUnderwriterCase);
	}
}
