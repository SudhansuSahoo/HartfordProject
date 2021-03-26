package com.hig.oracleformsmigration.repository;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.Sponsor;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long>{
	
	@Query(value = "select dscrptn,spnsrid from sponsor order by dscrptn", nativeQuery = true)
    List<Sponsor> getSponsor();
}
