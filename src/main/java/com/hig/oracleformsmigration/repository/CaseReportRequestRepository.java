package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.Sponsor;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorResponse;

@Repository
public interface CaseReportRequestRepository extends JpaRepository<Sponsor, Long>{

	@Query(value = "select new com.hig.oracleformsmigration.lossprocessing.model.SponsorResponse(s.dscrptn,s.spnsrId) from Sponsor s where s.spnsrId in(select distinct spnsrId from ViewCaseClient1 where caseId in (select distinct caseId from CaseReportRequest where rprttypId=6))order by s.dscrptn asc" ) 
	 public List<SponsorResponse> getSponsorBasedOnCaseReport();
	
	
}
