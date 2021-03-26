package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.BenefitDescription;

@Repository
public interface BenefitDescriptionRepository extends JpaRepository<BenefitDescription, String>{
	
	@Query(value = "SELECT BNFTCD, DSCRPTN, TXBLBNFTIND, CVRGCTGRYCD, LSSEXPRNCCD, SBCLMTYPCD, MJRLNCD, LSSRPRTNGGRPNGCD FROM PL_BENEFIT_CODE WHERE BNFTCD = :bnftcd", nativeQuery = true)
	BenefitDescription getBenefitCode(@Param("bnftcd")String bnftcd); 
	
}
