package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.casemanagement.model.ViewPolicyNumberUndrwrtr;

@Repository
public interface ViewPolicyNumberUndrwrtrRepository extends JpaRepository<ViewPolicyNumberUndrwrtr, Long>{

	@Query(value = "select PLCYNBR from view_policy_number_undrwrtr1 e WHERE e.undrwrtr IN (:underwriters)ORDER BY PLCYNBR", nativeQuery = true)
    List<ViewPolicyNumberUndrwrtr> getViewPolicyNumber(@Param("underwriters")List<String> underwriters);
}
