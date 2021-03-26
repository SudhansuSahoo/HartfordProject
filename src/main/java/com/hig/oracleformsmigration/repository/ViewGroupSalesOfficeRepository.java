package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.hig.oracleformsmigration.casemanagement.model.ViewGroupSalesOffice;

public interface ViewGroupSalesOfficeRepository extends JpaRepository<ViewGroupSalesOffice, Long>{
	
	
	@Query(value = "SELECT SLSOFFCCD, NAME FROM VIEW_GROUP_SALES_OFFICE1 where SLSOFFCCD != 99 ORDER BY NAME", nativeQuery = true) 
	List<ViewGroupSalesOffice> getSalesOfficeRepsIDNotEquals();

}
