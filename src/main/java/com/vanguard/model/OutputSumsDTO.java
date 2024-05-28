package com.vanguard.model;

public class OutputSumsDTO {
	public double iAsum;
	public double jobSum;
	public double SRSum;
	public double SPSum;
	public double getiAsum() {
		return iAsum;
	}
	public void setiAsum(double iAsum) {
		this.iAsum = iAsum;
	}
	public double getJobSum() {
		return jobSum;
	}
	public void setJobSum(double jobSum) {
		this.jobSum = jobSum;
	}
	public double getSRSum() {
		return SRSum;
	}
	public void setSRSum(double sRSum) {
		SRSum = sRSum;
	}
	public double getSPSum() {
		return SPSum;
	}
	public void setSPSum(double sPSum) {
		SPSum = sPSum;
	}
	public OutputSumsDTO(double iAsum, double jobSum, double sRSum, double sPSum) {
		super();
		this.iAsum = iAsum;
		this.jobSum = jobSum;
		SRSum = sRSum;
		SPSum = sPSum;
	}
	@Override
	public String toString() {
		return "OutputSumsDTO [iAsum=" + iAsum + ", jobSum=" + jobSum + ", SRSum=" + SRSum + ", SPSum=" + SPSum + "]";
	}
	
	
	
}
 

