package com.vanguard.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vanguard.model.ProductFamily;

public interface ProductFamilyRepository extends JpaRepository<ProductFamily,String>{
	
}