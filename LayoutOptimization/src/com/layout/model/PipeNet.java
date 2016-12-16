package com.layout.model;

import java.util.ArrayList;
import java.util.List;

public class PipeNet {
	private int eNumber;// ���������ֶ�����

	private int nNumber;// �ڵ������ֶ�����

	private double aCoef;// ����ϵ��a���ֶ�����

	private double bCoef;// ����ϵ��b���ֶ�����

	private List<PipeTreeNode> nodes;// �ڵ�����

	private List<PipeEdge> edges;// ������

	private int[][] aKN;// �ڵ���ܵ����ӣ��൱���ڽӾ��󣬵�ֻ�������ǣ��ֶ�����nNumber*nNumber��Ԫ��

	private double[][] aLN;// �ڵ�֮��ľ��룬����㣬nNumber*nNumber��Ԫ�ء�

	private List<BEdge> aNB;// �ߵı�ţ�eNumber��Ԫ�ء�

	private int[][] aBT;// ������ʱ�õķ�����ϵ������nNumber*eNumber��Ԫ�ء�
	
	private double vMin;
	

	public int[][] getaKN() {
		return aKN;
	}

	public void setaKN(int[][] aKN) {
		this.aKN = aKN;
	}

	public double[][] getaLN() {
		return aLN;
	}

	public void setaLN(double[][] aLN) {
		this.aLN = aLN;
	}

	public List<BEdge> getaNB() {
		return aNB;
	}

	public void setaNB(List<BEdge> aNB) {
		this.aNB = aNB;
	}

	public int[][] getaBT() {
		return aBT;
	}

	public void setaBT(int[][] aBT) {
		this.aBT = aBT;
	}

	public double getvMin() {
		return vMin;
	}

	public void setvMin(double vMin) {
		this.vMin = vMin;
	}

	public PipeNet() {
	}

	public PipeNet(List<PipeTreeNode> nodes, List<PipeEdge> edges) {
		this.nodes = nodes;
		this.edges = edges;
		this.nNumber = nodes.size();
		this.eNumber = edges.size();
		this.aKN = new int[this.nNumber][this.nNumber];
		this.aLN = new double[this.nNumber][this.nNumber];
		this.aNB = new ArrayList<BEdge>();
		this.aLN=new double[nNumber][nNumber];
		this.aBT=new int[nNumber][eNumber];
		this.calcLN();
		this.generateKN();
		this.generateNB();
		this.generateBt();
	}


	private void generateBt() {
		for (int i = 0; i < nNumber; i++)
			for (int j = 0; j < eNumber; j++) {
				if (aNB.get(j).getsNode() == i+1)
					aBT[i][j] = 1;
				else if (aNB.get(j).geteNode() == i+1)
					aBT[i][j] = -1;
				else
					aBT[i][j] = 0;
			}

	}

	private void generateKN() {
		for (PipeEdge edge : edges) {
			if (edge.getsNode() < edge.geteNode()) {
				this.aKN[edge.getsNode() - 1][edge.geteNode() - 1] = 1;
			}
		}
	}

	private void generateNB() {
		for (int i = 0; i < this.aKN.length; i++) {
			for (int j = 0; j < this.aKN[i].length; j++) {
				if (this.aKN[i][j] == 1) {
					BEdge edge = new BEdge(i+1 , j+1 );
					aNB.add(edge);
				}
			}
		}
	}

	private void calcLN() {
		for (int i = 0; i < this.nNumber; i++) {
			for (int j = 0; j < this.nNumber; j++) {
				double tempx = this.nodes.get(i).getNw().getX()
						- this.nodes.get(j).getNw().getX();
				double tempy = this.nodes.get(i).getNw().getY()
						- this.nodes.get(j).getNw().getY();
				this.aLN[i][j] = Math.sqrt(tempx * tempx + tempy * tempy);

			}
		}
	}

	public int geteNumber() {
		return eNumber;
	}

	public void seteNumber(int eNumber) {
		this.eNumber = eNumber;
	}

	public int getnNumber() {
		return nNumber;
	}

	public void setnNumber(int nNumber) {
		this.nNumber = nNumber;
	}

	public double getaCoef() {
		return aCoef;
	}

	public void setaCoef(double aCoef) {
		this.aCoef = aCoef;
	}

	public double getbCoef() {
		return bCoef;
	}

	public void setbCoef(double bCoef) {
		this.bCoef = bCoef;
	}

	public List<PipeTreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<PipeTreeNode> nodes) {
		this.nodes = nodes;
	}

	public List<PipeEdge> getEdges() {
		return edges;
	}

	public void setEdges(List<PipeEdge> edges) {
		this.edges = edges;
	}

	public int[][] getKn() {
		return aKN;
	}

	public void setKn(int[][] kn) {
		this.aKN = kn;
	}

	public double[][] getLn() {
		return aLN;
	}

	public void setLn(double[][] ln) {
		this.aLN = ln;
	}

	public int[][] getBt() {

		return aBT;
	}

	public List<BEdge> getnB() {
		return aNB;
	}

	public void setnB(List<BEdge> nB) {
		this.aNB = nB;
	}

	public void setBt(int[][] bt) {
		this.aBT = bt;
	}

}
