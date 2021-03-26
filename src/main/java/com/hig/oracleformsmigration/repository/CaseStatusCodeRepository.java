package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.casemanagement.model.CaseStatusCode;

@Repository
public interface CaseStatusCodeRepository extends JpaRepository<CaseStatusCode, Long>{
	
	@Query(value = "select STTSCD,DSCRPTN from CASE_STATUS_CODE ORDER BY DSCRPTN", nativeQuery = true)
    List<CaseStatusCode> getStatusCode();
	
}
