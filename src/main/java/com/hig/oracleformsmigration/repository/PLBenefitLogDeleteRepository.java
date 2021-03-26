package com.hig.oracleformsmigration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.PlBenitfitLogTable;

@Repository
public interface PLBenefitLogDeleteRepository extends JpaRepository<PlBenitfitLogTable, String>{

}
