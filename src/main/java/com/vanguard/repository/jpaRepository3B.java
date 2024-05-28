package com.vanguard.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vanguard.model.Vanguard3B;



 
 
@Repository
public interface jpaRepository3B extends JpaRepository<Vanguard3B, Integer> {
 
	@Query("select sum(TSP) from Vanguard3B where Category='Impact Analysis'")
	Double iAsum();
	@Query("select sum(TSP) from Vanguard3B where Category='Jobs'")
	Double jobSum();
	@Query("select sum(TSP) from Vanguard3B where Category='SR'")
	Double SRSum();

	@Query("select sum(TSP) from Vanguard3B where Category='SP'")
	Double SPSum();
	
	
	@Transactional
	@Modifying
	 @Query(nativeQuery = true, value ="update Vanguard3B e set e.Value = :Value, e.TSP = :Value * e.SPUnit  where e.ParaM = :ParaM")
	    void updateValue(@Param("ParaM") String ParaM, @Param("Value") int Value);
}
 