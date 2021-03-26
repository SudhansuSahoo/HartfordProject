package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistributionEmailReport;

@Repository
public interface PlBatchReportDistListRepository extends JpaRepository<PlBatchReportDistributionEmailReport, Long>{
	
	@Query(value = "select EMLDSTNTN, USRNM, EMLTYPCD, PRCSSDT, PRCSRID from PL_BATCH_REPORT_DIST_LIST e where e.emldstntn like %:emailDistribution%", nativeQuery = true)
    List<PlBatchReportDistributionEmailReport> getReportDL(@Param("emailDistribution")String emailDistribution);

}
