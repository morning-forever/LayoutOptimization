package com.diameter.algorithm;




public class DiameterIndividual implements Comparable<DiameterIndividual>{
	private int[] chrom;

	private double dCA;
	private double dCQ;
	private double dCR;
	private double dCTZ;
	private double fitness;
	public DiameterIndividual() {
		super();
	}
	public DiameterIndividual(int[] chrom){
		this.chrom=chrom;
	}
	
	public DiameterIndividual(int[] chrom, double dCA, double dCQ, double dCR,
			double dCTZ, double fitness) {
		super();
		this.chrom = chrom;
		this.dCA = dCA;
		this.dCQ = dCQ;
		this.dCR = dCR;
		this.dCTZ = dCTZ;
		this.fitness = fitness;
	}
	public int[] getChrom() {
		return chrom;
	}
	public void setChrom(int[] chrom) {
		this.chrom = chrom;
	}
	public double getdCA() {
		return dCA;
	}
	public void setdCA(double dCA) {
		this.dCA = dCA;
	}
	public double getdCQ() {
		return dCQ;
	}
	public void setdCQ(double dCQ) {
		this.dCQ = dCQ;
	}
	public double getdCR() {
		return dCR;
	}
	public void setdCR(double dCR) {
		this.dCR = dCR;
	}
	public double getdCTZ() {
		return dCTZ;
	}
	public void setdCTZ(double dCTZ) {
		this.dCTZ = dCTZ;
	}
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	@Override
	public int compareTo(DiameterIndividual individual) {
		if(this.fitness<individual.getFitness()) return -1;
		if(this.fitness==individual.getFitness())return 0;
		else return 1;
	}
	
	public DiameterIndividual clone(){
		
		int[] chrom=new int[this.chrom.length];
		for(int i=0;i<this.chrom.length;i++){
			chrom[i]=this.chrom[i];
		}
		return new DiameterIndividual(chrom, this.fitness,this.dCA,this.dCQ,this.dCR,this.dCTZ);
	
	}
	@Override
	public boolean equals(Object object) {
		
		if(object!=null){
			if(object instanceof DiameterIndividual){
				DiameterIndividual unit=(DiameterIndividual)object;
				boolean flag=true;
				for(int i=0;i<this.chrom.length;i++){
					if(this.chrom[i]==unit.chrom[i]){}else{
						flag=false;
					}
				}
				return flag;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
	}
	
}
