package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.casemanagement.model.ViewHigAllRep;
import com.hig.oracleformsmigration.casemanagement.model.ViewHigRep;

@Repository
public interface ViewHigAllRepRepository extends JpaRepository<ViewHigAllRep, Long>{
	
	@Query(value = "SELECT REPID, NAME FROM VIEW_HIG_ALL_REP1 WHERE REPRLTYPCD IN (:ids) ORDER BY NAME", nativeQuery = true)
    List<ViewHigAllRep> getViewHighAllSalesRepSVC(@Param("ids")List<String> ids);

}
