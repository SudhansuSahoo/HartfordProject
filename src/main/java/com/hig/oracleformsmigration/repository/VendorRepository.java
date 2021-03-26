package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.casemanagement.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{
	@Query(value = "SELECT VNDRID,NAME FROM VENDOR order by NAME", nativeQuery = true)
    List<Vendor> getVendor();
	
}
