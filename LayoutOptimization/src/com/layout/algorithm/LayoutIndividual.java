package com.layout.algorithm;

public class LayoutIndividual implements Comparable<LayoutIndividual>{
	private int[] chrom;
	
	private double fitness;
	


	public LayoutIndividual(int[] chrom, double fitness) {
		super();
		this.chrom = chrom;
		this.fitness = fitness;
	}


	public int[] getChrom() {
		return chrom;
	}

	
	public LayoutIndividual(int[] chrom) {
		super();
		this.chrom = chrom;
	}


	public void setChrom(int[] chrom) {
		this.chrom = chrom;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public LayoutIndividual clone(){
		
			int[] chrom=new int[this.chrom.length];
			for(int i=0;i<this.chrom.length;i++){
				chrom[i]=this.chrom[i];
			}
			return new LayoutIndividual(chrom,this.fitness);
		
	}


	@Override
	public int compareTo(LayoutIndividual individual) {
		if(this.fitness<individual.getFitness()) return -1;
		if(this.fitness==individual.getFitness())return 0;
		else return 1;
		
	}


	@Override
	public boolean equals(Object object) {
		
		if(object!=null){
			if(object instanceof LayoutIndividual){
				LayoutIndividual unit=(LayoutIndividual)object;
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
