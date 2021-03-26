package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.casemanagement.model.CaseStatUnderWriterMaintRelationshipEntityResponse;
import com.hig.oracleformsmigration.casemanagement.model.ViewCmUnderwriterMaint;
import com.hig.oracleformsmigration.casemanagement.model.ViewHigRep;

@Repository
public interface CaseStatUnderWriterRelationshipRepository extends JpaRepository<ViewCmUnderwriterMaint, Long>{
	
	/*
	 * @Query("select new com.hig.oracleformsmigration.model.CaseStatUnderWriterMaintRelationshipEntity(c.id,p.name) from ViewCmUnderwriterMaint c JOIN c.CaseStatUnderwriter p"
	 * ) public List<CaseStatUnderWriterMaintRelationshipEntity>
	 * getJoinInformation();
	 */

}
