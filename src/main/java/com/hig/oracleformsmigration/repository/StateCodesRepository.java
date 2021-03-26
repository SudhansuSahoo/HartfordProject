package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.hig.oracleformsmigration.casemanagement.model.StateCodesEntity;

public interface StateCodesRepository extends JpaRepository<StateCodesEntity, Long>{
	
	@Query(value = "select STCD,NAME,WDIND,PRMMTXLCTNCDIND,LGLSTCDIND from STATE_CODES ORDER BY NAME", nativeQuery = true) 
	List<StateCodesEntity> getStateCodes();

}
