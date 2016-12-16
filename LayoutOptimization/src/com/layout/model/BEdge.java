package com.layout.model;

public class BEdge {
	private int sNode;	//边的起始节点号
	private int eNode;	//边的结束节点号
	
	public BEdge() {
		super();
	}
	
	public BEdge(int sNode, int eNode) {
		super();
		this.sNode = sNode;
		this.eNode = eNode;
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

	@Override
	public String toString() {
		return "("+sNode+","+eNode+")";
	}
	
}
