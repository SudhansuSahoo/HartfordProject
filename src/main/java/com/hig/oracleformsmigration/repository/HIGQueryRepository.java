package com.hig.oracleformsmigration.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.hig.oracleformsmigration.casemanagement.model.ViewHigRep;


@Repository
public interface HIGQueryRepository extends JpaRepository<ViewHigRep, Long>{
	
	@Query(value = "SELECT REPID, NAME FROM VIEW_HIG_REP1 WHERE REPRLTYPCD IN (:ids) ORDER BY NAME", nativeQuery = true)
    List<ViewHigRep> getViewHigRep(@Param("ids")List<String> ids);
	
	@Query(value = "SELECT distinct REPID, NAME FROM VIEW_HIG_ALL_REP1 WHERE REPRLTYPCD IN (:ids) ORDER BY NAME", nativeQuery = true)
    List<ViewHigRep> getNewSalesRep(@Param("ids")List<String> ids);
	
	@Query(value = "SELECT REPID, NAME FROM VIEW_HIG_REP1 WHERE REPRLTYPCD IN (:ids) ORDER BY NAME", nativeQuery = true)
    List<ViewHigRep> getViewHigAllRep(@Param("ids")List<String> ids);
	
	@Query(value = "SELECT REPID, NAME FROM VIEW_HIG_REP1 WHERE REPRLTYPCD IN (:ids) ORDER BY NAME", nativeQuery = true)
    List<ViewHigRep> getViewHighSalesRepSVC(@Param("ids")String id);
	
	
	
}
