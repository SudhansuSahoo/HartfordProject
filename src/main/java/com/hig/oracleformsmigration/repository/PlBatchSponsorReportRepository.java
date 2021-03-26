package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.BenefitDescription;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReportBasedOnSponsorID;

@Repository
public interface PlBatchSponsorReportRepository extends JpaRepository<PlBatchSponsorReportBasedOnSponsorID, String>{

	
	@Query(value = "Select * from PL_BATCH_SPONSOR_REPORT where BUS_SPNSR_ID = :ids", nativeQuery = true)
    List<PlBatchSponsorReportBasedOnSponsorID> getBasedOnSponsorSelected(@Param("ids")String ids);
	
	
}
