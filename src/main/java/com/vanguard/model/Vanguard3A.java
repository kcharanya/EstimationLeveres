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
@Table(name = "vanguard3a")
public class Vanguard3A {
	@Id
	public int Sno;
	public int getSno() {
		return Sno;
	}



	public void setSno(int sno) {
		Sno = sno;
	}



	public String getCategory() {
		return Category;
	}



	public void setCategory(String category) {
		Category = category;
	}



	public String getELevers() {
		return ELevers;
	}



	public void setELevers(String eLevers) {
		ELevers = eLevers;
	}



	public String getParaM() {
		return ParaM;
	}



	public void setParaM(String paraM) {
		ParaM = paraM;
	}



	public int getValue() {
		return Value;
	}



	public void setValue(int value) {
		Value = value;
	}



	public double getSPUnit() {
		return SPUnit;
	}



	public void setSPUnit(double sPUnit) {
		SPUnit = sPUnit;
	}



	public double getTSP() {
		return TSP;
	}



	public void setTSP(double tSP) {
		TSP = tSP;
	}



	public String getNotes() {
		return Notes;
	}



	public void setNotes(String notes) {
		Notes = notes;
	}



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



	@Override
	public String toString() {
		return "Vanguard3A [Sno=" + Sno + ", Category=" + Category + ", ELevers=" + ELevers + ", ParaM=" + ParaM
				+ ", Value=" + Value + ", SPUnit=" + SPUnit + ", TSP=" + TSP + ", Notes=" + Notes + "]";
	}
	 
	 
}

