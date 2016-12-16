package com.layout.model;

public class PipeEdge {
	private int id;	//序号
	private int sNode;	//边的起始节点号
	private int eNode;	//边的结束节点号
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
