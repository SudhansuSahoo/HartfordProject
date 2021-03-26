package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.casemanagement.model.CaseStatUnderWriterMaintRelationshipEntityResponse;
import com.hig.oracleformsmigration.casemanagement.model.CaseStatunderwriterEntity;

@Repository
public interface CaseStatUnderWriterMainRelationshipRepository extends JpaRepository<CaseStatunderwriterEntity, String>{
	
	 @Query(value = "select distinct new com.hig.oracleformsmigration.casemanagement.model.CaseStatUnderWriterMaintRelationshipEntityResponse(c.name,p.statUnderwriter) from ViewCmUnderwriterMaint1Entity c INNER JOIN c.caseStatunderwriterEntity p order by c.name" ) 
	 public List<CaseStatUnderWriterMaintRelationshipEntityResponse> getJoinInformation();
     
}