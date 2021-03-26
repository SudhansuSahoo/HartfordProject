package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.hig.oracleformsmigration.casemanagement.model.ViewStatUnderwriter;

public interface ViewStatUnderwriterRepository extends JpaRepository<ViewStatUnderwriter, String>{
	
	
	@Query(value = "SELECT UNDRWRTR,NAME,DSCRPTN FROM VIEW_STAT_UNDERWRITER1 ORDER BY NAME", nativeQuery = true)
    List<ViewStatUnderwriter> getStatUnderWriterDetails();
}
