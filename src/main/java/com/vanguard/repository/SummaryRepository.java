package com.vanguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vanguard.model.Summary;
import java.util.List;


public interface SummaryRepository extends JpaRepository<Summary,Integer>{
	public List<Summary> findByProductFamilyAndTableNameAndImpactAnlaysisAndJobsAndSrAndSp(String productFamily, String tableName, double impactAnlaysis, double jobs, double sr, double sp);

}
