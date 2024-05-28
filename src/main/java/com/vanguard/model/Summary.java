package com.vanguard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="summary", uniqueConstraints = @UniqueConstraint(columnNames = {
        "productFamily", "tableName", "impactAnlaysis", "jobs", "sr", "sp"
}))
public class Summary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sNo;
	private String productFamily;
	private String tableName;
	private double impactAnlaysis;
	private double jobs;
	private double sr;
	private double sp;
	private double tsp;
	private double nps;
}

