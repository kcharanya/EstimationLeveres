package com.vanguard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vanguard3c")
public class Vanguard3C{
	@Id
	public int Sno;
	public String Category;
	public String ELevers;
	public String ParaM;
	public int Value;
	public double SPUnit;
	public double TSP;
	public String  Notes;

	 @PrePersist
	 @PreUpdate
	    public void updateTSP() {
	        this.TSP = this.Value * this.SPUnit;
	    }
}

