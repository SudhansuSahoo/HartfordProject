package com.hig.oracleformsmigration.repository;

import java.util.HashMap;
import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.hig.oracleformsmigration.model.ErrorDetails;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistList;

@Repository
public interface InsDelMailDistRepository extends CrudRepository<PlBatchReportDistList, Long> {

	@Procedure(name = "LP_INS_DEL_MAILDIST")
	HashMap<String, String> saveInsDelMailDistsp(@Param("pmailid") String pmailid,
			@Param("pmaildistribution") String pmaildistribution, @Param("puserid") String puserid,	@Param("paction") String paction);
}
