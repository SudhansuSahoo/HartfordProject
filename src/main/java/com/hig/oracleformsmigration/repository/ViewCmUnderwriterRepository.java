package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hig.oracleformsmigration.casemanagement.model.ViewCmUnderwriterMaint;


public interface ViewCmUnderwriterRepository extends JpaRepository<ViewCmUnderwriterMaint, String>{
	@Query(value = "SELECT UNDRWRTR,NAME FROM VIEW_CM_UNDERWRITER_MAINT1 ORDER BY NAME", nativeQuery = true)
    List<ViewCmUnderwriterMaint> getUnderWriterDetails();
	
}
