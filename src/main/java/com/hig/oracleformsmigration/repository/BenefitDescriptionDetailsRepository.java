package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.BenefitDescription;

@Repository
public interface BenefitDescriptionDetailsRepository extends JpaRepository<BenefitDescription, String>{
	
	@Query(value = "SELECT * FROM PL_BENEFIT_CODE where BNFTCD = :bnftcd", nativeQuery = true)
    List<BenefitDescription> getBenefitCode(@Param("bnftcd")String bnftcd);

}
