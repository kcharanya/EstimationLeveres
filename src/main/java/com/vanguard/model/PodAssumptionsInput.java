package com.vanguard.model;
 
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "podassumptionsinput")
public class PodAssumptionsInput {
	@Id
private String miningparameters;
	public double firstName; 
	public double secondName;
	public double thirdName;
	public double fourthName;
	public double fifthName;
	public double sixthName;
	public double seventhName;
	public double eightName;
	public double ninthName;
	public double tenName;
	}
 


