package com.vanguard.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "podassumptions")
public class PodAssumptions {
	@Id
	private String miningparameters;
	private double SprintHours;
	
//	@OneToMany(mappedBy ="PodAssumptions",cascade = CascadeType.ALL )
//	private List<PodAssumptionsInput>podassumptionsinput;


}
