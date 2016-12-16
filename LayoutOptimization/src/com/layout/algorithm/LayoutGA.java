package com.layout.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.layout.model.PipeNet;
import com.util.Utils;

public class LayoutGA {
	private PipeNet pipeNet;
	private int popSize;
	private int maxGen;
	private float pS;
	private float pT;
	private List<LayoutIndividual> parents;
	private List<LayoutIndividual> children;
	private List<LayoutIndividual> parAndChi;
	private double[][] aQKN;
	private double[][] aDKN;
	private double[] aQNP;

	public LayoutGA(PipeNet pipeNet, int popSize, int maxGen, float pS, float pT) {
		super();
		this.pipeNet = pipeNet;
		this.popSize = popSize;
		this.maxGen = maxGen;
		this.pS = pS;
		this.pT = pT;

		this.aQKN = new double[this.pipeNet.getnNumber()][this.pipeNet
				.getnNumber()];
		this.aDKN = new double[this.pipeNet.getnNumber()][this.pipeNet
				.getnNumber()];
		this.aQNP = new double[this.pipeNet.geteNumber()];
		this.parents = new ArrayList<LayoutIndividual>();
		this.children = new ArrayList<LayoutIndividual>();
		this.parAndChi = new ArrayList<LayoutIndividual>();
		initPop();

	}

	private void calcDKN() {

		/*for (int i = 0; i < pipeNet.getnNumber(); i++) {
			for (int j = 0; j < pipeNet.getnNumber(); j++) {
				this.aDKN[i][j] = 1000 * Math.sqrt((4 * this.aQKN[i][j])
						/ (3600 * Utils.PI * this.pipeNet.getvMin()));
			}
		}*/
	}

	private void calcQKN() {
		/*for (int row = 0; row < this.pipeNet.getnNumber(); row++)
			for (int col = 0; col < this.pipeNet.geteNumber(); col++) {
				aQKN[row][col] = this.pipeNet.getKn()[row][col];
			}
		int no = 0;
		for (int row = 0; row < pipeNet.getnNumber(); row++)
			for (int col = 0; col < pipeNet.getnNumber(); col++) {
				if (this.aQKN[row][col] == 1) {
					this.aQKN[row][col] = this.aQNP[no];
					no++;
				}
			}*/

	}

	private void calcQNP(LayoutIndividual individual) {

	}

	public PipeNet getPipeNet() {
		return pipeNet;
	}

	public void setPipeNet(PipeNet pipeNet) {
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

	public float getpS() {
		return pS;
	}

	public void setpS(float pS) {
		this.pS = pS;
	}

	public float getpT() {
		return pT;
	}

	public void setpT(float pT) {
		this.pT = pT;
	}

	public List<LayoutIndividual> getParents() {
		return parents;
	}

	public void setParents(List<LayoutIndividual> parents) {
		this.parents = parents;
	}

	public List<LayoutIndividual> getChildren() {
		return children;
	}

	public void setChildren(List<LayoutIndividual> children) {
		this.children = children;
	}

	public List<LayoutIndividual> getParAndChi() {
		return parAndChi;
	}

	public void setParAndChi(List<LayoutIndividual> parAndChi) {
		this.parAndChi = parAndChi;
	}

	public double[][] getQkn() {
		return aQKN;
	}

	public void setQkn(double[][] qkn) {
		this.aQKN = qkn;
	}

	public double[][] getDkn() {
		return aDKN;
	}

	public void setDkn(double[][] dkn) {
		this.aDKN = dkn;
	}

	public double[] getQnp() {
		return aQNP;
	}

	public void setQnp(double[] qnp) {
		this.aQNP = qnp;
	}

	public boolean isTree(LayoutIndividual individual) {
		// ToDO
		return false;
	}

	public List<LayoutIndividual> removeSame(List<LayoutIndividual> individuals) {

		return null;
	}

	public void initPop() {
		for (; parents.size() < popSize;) {
			int[] chrom = new int[pipeNet.geteNumber()];
			do {
				for (int j = 0; j < pipeNet.geteNumber(); j++) {
					byte bit = (byte) (Math.random() > 0.5 ? 1 : 0);// ������0��1
					chrom[j] = bit;
				}

			} while (!Utils.isTree(chrom, pipeNet));// �����������������������壬ֱ������Ϊֹ

			LayoutIndividual individual = new LayoutIndividual(chrom);

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
	public boolean isExist(List<LayoutIndividual> individuals, LayoutIndividual individual) {
		if (individual == null) {
			return true;
		} else {
			if (individuals != null && individuals.size() > 0) {

				boolean flag = false;

				for (LayoutIndividual element : individuals) {
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

	/**
	 * �жϼ������Ƿ���������ͬ�Ķ���
	 * 
	 * @param units
	 * @return
	 */
	public static boolean existTwoSameObject(List<LayoutIndividual> individuals) {
		if (individuals != null && individuals.size() > 1) {
			boolean flag = false;
			for (int i = 0; i < individuals.size() - 1; i++) {
				if (individuals.get(i) != null) {
					for (int j = i + 1; j < individuals.size(); j++) {
						if (individuals.get(j) != null) {
							if (individuals.get(i).equals(individuals.get(j))) {
								flag = true;
							}
						}
					}
				}
			}
			return flag;

		} else {
			return false;
		}
	}

	/**
	 * ���ϵ����
	 * 
	 * @param units
	 * @return
	 */
	public List<LayoutIndividual> individualsCopy(List<LayoutIndividual> individuals) {
		List<LayoutIndividual> result = new ArrayList<LayoutIndividual>();
		for (LayoutIndividual individual : individuals) {
			LayoutIndividual element = individual.clone();
			result.add(element);
		}
		return result;
	}

	public void generateChildren() {

		children.clear();
		List<LayoutIndividual> tempParent = individualsCopy(this.parents);

		for (LayoutIndividual individual : tempParent) {
			int n1, n2;
			do {
				// ���ȡ��������ֵ��0�����峤��֮�䡣������������ȷ��Ҫ�仯�ø����е�����λ
				n1 = (int)(Math.random()*pipeNet.geteNumber());
				n2 = (int)(Math.random()*pipeNet.geteNumber());
				// ���������仯�����ж�Ӧλ�õ�ֵ
				if (individual.getChrom()[n1] == 1)
					individual.getChrom()[n1] = 0;
				else
					individual.getChrom()[n1] = 1;
				if (individual.getChrom()[n2] == 1)
					individual.getChrom()[n2] = 0;
				else
					individual.getChrom()[n2] = 1;
			} while (!Utils.isTree(individual.getChrom(), this.pipeNet)
					|| isExist(children, individual)
					|| isExist(this.parents, individual));
			calcFitness(individual);

			children.add(individual);
		}

	}

	public void generateZST() {
		parAndChi = new ArrayList<LayoutIndividual>();
		parAndChi.addAll(parents);
		parAndChi.addAll(children);
	}

	public void sort() {

		Collections.sort(parAndChi);
	}

	public void generateNewST() {
		this.parents = parAndChi.subList(0, this.popSize);
	}

	public void translate(LayoutIndividual oldIndividual, LayoutIndividual newIndividual) {
	}

	public List<LayoutIndividual> generateChildren(List<LayoutIndividual> parents) {
		return null;
	}

	public List<LayoutIndividual> generateParAndChi(List<LayoutIndividual> parents,
			List<LayoutIndividual> children) {
		return null;
	}

	public List<LayoutIndividual> sort(List<LayoutIndividual> individuals) {
		return null;
	}

	public void go() throws InterruptedException {
		initPop();
		for (int i = 0; i < this.maxGen; i++) {

			generateChildren();
			generateZST();
			sort();
			generateNewST();

		}
	}

	private void calcFitness(LayoutIndividual individual) {

		/*
		 * double x = 0; // ��ʾdkn�е�ĳһ��Ԫ�� calcQnp(individual); calcQkn();
		 * calcDKN(); for (int i = 0; i < this.pipeNet.getnNumber(); i++) { for
		 * (int j = 0; j < this.pipeNet.getnNumber(); j++) { x +=
		 * this.pipeNet.getaCoef() * this.dkn[i][j] this.pipeNet.getLn()[i][j]
		 * this.pipeNet.getKn()[i][j]; } } individual.setFitness(x);
		 */
		
		calcQNP(individual);
		calcQKN();
		calcDKN();
		
		
		
		individual.setFitness(0);
		for (int j = 0; j < this.pipeNet.geteNumber(); j++) {

			if (individual.getChrom()[j] == 1) {
				individual.setFitness(individual.getFitness()
						+ pipeNet.getEdges().get(j).getWeight());

			}
		}

	}
}
