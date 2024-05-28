package com.vanguard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vanguard.model.PodAssumptionsInput;

import jakarta.transaction.Transactional;

@Repository
public interface PodRepository extends JpaRepository<PodAssumptionsInput, String> {

	@Query("SELECT fifthName FROM PodAssumptionsInput WHERE miningparameters='Shrs'")
	List<Integer> fetchPodAssumption5();

	@Transactional
	@Modifying
	@Query("Update PodAssumptionsInput e Set e.fifthName= :miningparameters where e.miningparameters='Shrs'")
	PodAssumptionsInput updateMiningparameters(@Param("miningparameters") String miningparameters);
	
	
}