package com.hig.oracleformsmigration.repository;

import org.springframework.data.repository.CrudRepository;

import com.hig.oracleformsmigration.casemanagement.model.CaseManagementData;

public interface CaseManagementRepository extends CrudRepository<CaseManagementData,Long>{

}
