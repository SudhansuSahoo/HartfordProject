package com.hig.oracleformsmigration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hig.oracleformsmigration.lossprocessing.model.BatchSponsorDistributionReportRelationship;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReport;
@Repository
public interface BatchSponsorDistributionReportRelationshipRepository extends JpaRepository<PlBatchSponsorReport, Long>{
	
	 @Query(value = "select distinct new com.hig.oracleformsmigration.lossprocessing.model.BatchSponsorDistributionReportRelationship(c.usrnm,p.rptNm,p.rptDesc,c.emldstntn) from PlBatchReportDistributionList c INNER JOIN c.plBatchSponsorReport p where c.emldstntn like %:emailDistribution%" ) 
	 public List<BatchSponsorDistributionReportRelationship> getBatchSponsorDistributionReportRelationship(@Param("emailDistribution")String emailDistribution);

}
