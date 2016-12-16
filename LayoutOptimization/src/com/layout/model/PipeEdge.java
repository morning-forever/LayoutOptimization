package com.layout.model;

public class PipeEdge {
	private int id;	//���
	private int sNode;	//�ߵ���ʼ�ڵ��
	private int eNode;	//�ߵĽ����ڵ��
	private int weight;
	public PipeEdge() {
		super();
	}
	
	public PipeEdge(int id, int weight, int sNode, int eNode) {
		super();
		this.id = id;
		this.sNode = sNode;
		this.eNode = eNode;
		this.weight = weight;
	}

	public PipeEdge(int id, int sNode, int eNode) {
		super();
		this.id = id;
		this.sNode = sNode;
		this.eNode = eNode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getsNode() {
		return sNode;
	}
	public void setsNode(int sNode) {
		this.sNode = sNode;
	}
	public int geteNode() {
		return eNode;
	}
	public void seteNode(int eNode) {
		this.eNode = eNode;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
