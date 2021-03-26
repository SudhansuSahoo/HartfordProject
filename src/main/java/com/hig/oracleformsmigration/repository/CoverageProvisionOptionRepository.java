package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hig.oracleformsmigration.casemanagement.model.CoverageProvisionOptionEntity;


public interface CoverageProvisionOptionRepository extends JpaRepository<CoverageProvisionOptionEntity, Long>{
	
	
	@Query(value = "select DSCRPTN from COVERAGE_PROVISION_OPTION where PRVSNID='498' ORDER BY DSCRPTN", nativeQuery = true) 
	List<CoverageProvisionOptionEntity> getCoverageProvisionOptionEntity();
	
	@Query(value = "select DSCRPTN from COVERAGE_PROVISION_OPTION where PRVSNID='500' ORDER BY DSCRPTN", nativeQuery = true) 
	List<CoverageProvisionOptionEntity> getCoverageProvisionOptionAdditionalServiceTeam();
	
	@Query(value = "select DSCRPTN from COVERAGE_PROVISION_OPTION where PRVSNID='581' ORDER BY DSCRPTN", nativeQuery = true) 
	List<CoverageProvisionOptionEntity> getCoverageProvisionOptionCaseLabel();

}
