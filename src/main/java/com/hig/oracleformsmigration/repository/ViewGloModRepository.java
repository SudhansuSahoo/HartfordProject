package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.casemanagement.model.ViewGloMod;

@Repository
public interface ViewGloModRepository extends JpaRepository<ViewGloMod, Long>{
	
	@Query(value = "SELECT OPTNID,CASEID,VNDRID, SLSOFFCCD, SALESREP,SLSREPID,SVCREPID,CASENAME,SERVICETEAM, "
			+ "SALESOFFICE, PRODUCER, SERVICEREP, UNDRWRTR FROM VIEW_GLO_MOD1 where SALESREP = :salesrep ORDER BY CASENAME", nativeQuery = true)
    List<ViewGloMod> getGloMod(@Param("salesrep")String salesrep);
	
	@Query(value = "SELECT OPTNID,CASEID,VNDRID, SLSOFFCCD, SALESREP,SLSREPID,SVCREPID,CASENAME,SERVICETEAM, "
			+ "SALESOFFICE, PRODUCER, SERVICEREP, UNDRWRTR FROM VIEW_GLO_MOD1 where SVCREPID = :servicerep ORDER BY CASENAME", nativeQuery = true)
    List<ViewGloMod> getGloModByServiceRep(@Param("servicerep")String servicerep);
	
	@Query(value = "SELECT OPTNID,CASEID,VNDRID, SLSOFFCCD, SALESREP,SLSREPID,SVCREPID,CASENAME,SERVICETEAM, "
			+ "SALESOFFICE, PRODUCER, SERVICEREP, UNDRWRTR FROM VIEW_GLO_MOD1 where SLSOFFCCD = :salesoffice ORDER BY CASENAME", nativeQuery = true)
    List<ViewGloMod> getGloModBySalesOffice(@Param("salesoffice")String salesoffice);
	
	@Query(value = "SELECT OPTNID,CASEID,VNDRID, SLSOFFCCD, SALESREP,SLSREPID,SVCREPID,CASENAME,SERVICETEAM, "
			+ "SALESOFFICE, PRODUCER, SERVICEREP , UNDRWRTR FROM VIEW_GLO_MOD1 where PRODUCER = :producer and SLSOFFCCD = :salesoffice ORDER BY CASENAME", nativeQuery = true)
    List<ViewGloMod> getGloModByProducerAndSalesOffice(@Param("producer")String producer,@Param("salesoffice")String salesoffice);
}
