package com.diameter.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bean.DiameterParam;
import com.diameter.model.PipeTree;
import com.util.Utils;

public class DiameterGA {
	private PipeTree pipeNet;
	private int popSize;

	private int maxGen;
	private int[] aPWS;
	private int[] aPSS;
	private int[] aPBWS;
	private int[] aPBDX;

	private List<DiameterIndividual> parents;
	private List<DiameterIndividual> children;
	private List<DiameterIndividual> parAndChi;

	private double[][] aDM;
	
	/*private double[] aDMM;
	private double[] aWKHD;
	private double[] aBWHD;*/

	public DiameterGA() {
		super();
	}

	public DiameterGA(PipeTree pipeNet,int popSize, int maxGen) {
		super();
		this.pipeNet = pipeNet;
		this.popSize = popSize;
		this.maxGen = maxGen;
		this.parents=new ArrayList<DiameterIndividual>();
		this.children=new ArrayList<DiameterIndividual>();
		this.parAndChi=new ArrayList<DiameterIndividual>();
	}

	
	public PipeTree getPipeNet() {
		return pipeNet;
	}

	public void setPipeNet(PipeTree pipeNet) {
		this.pipeNet = pipeNet;
	}

	public int getPopSize() {
		return popSize;
	}

	public void setPopSize(int popSize) {
		this.popSize = popSize;
	}


	public int getMaxGen() {
		return maxGen;
	}

	public void setMaxGen(int maxGen) {
		this.maxGen = maxGen;
	}

	public int[] getaPWS() {
		return aPWS;
	}

	public void setaPWS(int[] aPWS) {
		this.aPWS = aPWS;
	}

	public int[] getaPSS() {
		return aPSS;
	}

	public void setaPSS(int[] aPSS) {
		this.aPSS = aPSS;
	}

	public int[] getaPBWS() {
		return aPBWS;
	}

	public void setaPBWS(int[] aPBWS) {
		this.aPBWS = aPBWS;
	}

	public int[] getaPBDX() {
		return aPBDX;
	}

	public void setaPBDX(int[] aPBDX) {
		this.aPBDX = aPBDX;
	}

	public List<DiameterIndividual> getParents() {
		return parents;
	}

	public void setParents(List<DiameterIndividual> parents) {
		this.parents = parents;
	}

	public List<DiameterIndividual> getChildren() {
		return children;
	}

	public void setChildren(List<DiameterIndividual> children) {
		this.children = children;
	}

	public List<DiameterIndividual> getParAndChi() {
		return parAndChi;
	}

	public void setParAndChi(List<DiameterIndividual> parAndChi) {
		this.parAndChi = parAndChi;
	}

	public double[][] getaDM() {
		return aDM;
	}

	public void setaDM(double[][] aDM) {
		this.aDM = aDM;
	}

	public void initPop() {
		for (; parents.size() < popSize;) {
			int[] chrom = new int[pipeNet.getEdges().size()];

			for (int j = 0; j < pipeNet.getEdges().size(); j++) {
				int n = (int) (Math.random() * pipeNet.getPipeKinds().size()) + 1;
				chrom[j] = n;
			}

			DiameterIndividual individual = new DiameterIndividual(chrom);

			if (!isExist(parents, individual)) {// �����Ⱥ�в������ɵĸ��壬�򽫸ø��������Ⱥ�С�
				calcFitness(individual);
				parents.add(individual);
			}
			

		}

	}

	/**
	 * �ж���Ⱥ���Ƿ��Ѵ�����ͬ�ĸ���
	 * 
	 * @param units
	 * @param unit
	 * @return
	 */
	public boolean isExist(List<DiameterIndividual> individuals, DiameterIndividual individual) {
		if (individual == null) {
			return true;
		} else {
			if (individuals != null && individuals.size() > 0) {

				boolean flag = false;

				for (DiameterIndividual element : individuals) {
					if (individual.equals(element)) {
						flag = true;
						break;
					}
				}
				return flag;
			} else {
				return false;
			}
		}

	}

	public void generateChildren() {

		children.clear();
		List<DiameterIndividual> tempParent = individualsCopy(this.parents);

		for (DiameterIndividual individual : tempParent) {
			int n1, n2;
			do {
				// ���ȡ��������ֵ��0�����峤��֮�䡣������������ȷ��Ҫ�仯�ø����е�����λ
				n1 = (int) (Math.random() * pipeNet.getEdges().size());
				n2 = (int) (Math.random() * pipeNet.getEdges().size());
				int temp;
				temp = individual.getChrom()[n1];
				individual.getChrom()[n1] = individual.getChrom()[n2];
				individual.getChrom()[n2] = temp;

			} while (isExist(this.parents, individual)
					|| isExist(children, individual));

			calcFitness(individual);

			children.add(individual);
		}
	}

	/**
	 * ���ϵ����
	 * 
	 * @param units
	 * @return
	 */
	public List<DiameterIndividual> individualsCopy(List<DiameterIndividual> individuals) {
		List<DiameterIndividual> result = new ArrayList<DiameterIndividual>();
		for (DiameterIndividual individual : individuals) {
			DiameterIndividual element = individual.clone();
			result.add(element);
		}
		return result;
	}

	public void generateZST() {
		parAndChi = new ArrayList<DiameterIndividual>();
		parAndChi.addAll(parents);
		parAndChi.addAll(children);
	}

	public void sort() {

		Collections.sort(parAndChi);
	}

	public void generateNewST() {
		this.parents = parAndChi.subList(0, this.popSize);
	}

	private double[] generateDMM(DiameterIndividual individual) {
		int[] chrom = individual.getChrom();
		double[] aDMM = new double[chrom.length];

		for (int i = 0; i < chrom.length; i++) {
			aDMM[i] = this.pipeNet.getPipeKinds().get(chrom[i]-1).getdDN();
		}
		return aDMM;
		
	}

	private double[] generateBWHD(DiameterIndividual individual) {
		int[] chrom = individual.getChrom();
		double[] aBWHD = new double[chrom.length];
		for (int i = 0; i < chrom.length; i++) {
			aBWHD[i] = this.pipeNet.getPipeKinds().get(chrom[i]-1).getdBWHD();
		}
		return aBWHD;
		
	}

	private double[] generateWKHD(DiameterIndividual individual) {

		int[] chrom = individual.getChrom();
		double[] aWKHD=new double[chrom.length];
		for (int i = 0; i < chrom.length; i++) {
			aWKHD[i] = this.pipeNet.getPipeKinds().get(chrom[i]-1).getdWKHD();

		}
		return aWKHD;
	}

	private void calcCA(DiameterIndividual individual) {
		
		double dCA=pipeNet.getdP().getdAlpha()*individual.getdCTZ();
		individual.setdCA(dCA);
	};

	private void calcCQ(DiameterIndividual individual) {
		double[] dDMM=generateDMM(individual);
		double[] dWKHD=generateWKHD(individual);
		double[] dBWHD=generateBWHD(individual);
		
		double dCQ;
		DiameterParam dp=pipeNet.getdP();
		double deltaQ;
		double sum=0;
		for(int i=0;i<individual.getChrom().length;i++){
			double f=2*Utils.PI*dp.getdLumda()*pipeNet.getEdges().get(i).getdLND()*
					(2*dp.getdPipeTS()-dp.getdPipeTCS()-dp.getdPipeTCR());
			double m=Math.log((dDMM[i]*0.001+2*dWKHD[i]+2*dBWHD[i])/(dDMM[i]*0.001+2*dWKHD[i]));
			sum+=f/m;
		}
		deltaQ=sum;
		dCQ=(deltaQ*dp.getdCE()*dp.getdPipeT())/(dp.getdCOP()*Math.pow(10, 7));
		individual.setdCQ(dCQ);
	};

	private void calcCR(DiameterIndividual individual) {
		double[] dDMM=generateDMM(individual);
		double dHJ;
		double sum=0;
		for(int i=0;i<individual.getChrom().length;i++){
			double f=(6.88*Math.pow(10, 9)*Math.pow(pipeNet.getdP().getdPumpK(),0.25))*
					Math.pow(pipeNet.getEdges().get(i).getdQND(), 2)*
					(1+pipeNet.getdP().getdPumpA()*dDMM[i])*
					pipeNet.getEdges().get(i).getdLND();
			double m=pipeNet.getdP().getDensity()*Math.pow(dDMM[i]*0.001, 5.25);
			dHJ=f/m;
			sum+=dHJ;
		}
		double f=2.78*Math.pow(10, 7)*pipeNet.getdP().getdPumpG()*sum*
				pipeNet.getdP().getdPumpT()*pipeNet.getdP().getdCE();
		double m=pipeNet.getdP().getDensity()*pipeNet.getdP().getdPumpN();
		individual.setdCR(f/m);
	};
	

	private void calcCTZ(DiameterIndividual individual) {
		double[] dDMM=generateDMM(individual);
		
		double sum=0;
		for(int i=0;i<individual.getChrom().length;i++){
			sum+=(9.4868+4.942*dDMM[i])*pipeNet.getEdges().get(i).getdLND();
		}
		individual.setdCTZ(sum);
	};

	private void calcFitness(DiameterIndividual individual) {
		calcCTZ(individual);
		calcCA(individual);
		calcCQ(individual);
		calcCR(individual);
		double fitness=individual.getdCTZ()*pipeNet.getdP().getiZST()+
				individual.getdCR()+individual.getdCQ()+individual.getdCA();
		individual.setFitness(fitness);
	};
	
	public void go(){
		this.initPop();
		for (int i = 0; i < this.maxGen; i++) {

			generateChildren();
			generateZST();
			sort();
			generateNewST();

		}
		
	}
}
